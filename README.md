# prog2---pet-groomer

# Kisállat-kozmetika Foglalási Rendszer

Konzolos Java alkalmazás kisállat-kozmetikai időpontfoglalások kezelésére, egyedi jegyzetek (`Note`) rögzítésére, `Strategy` mintával megvalósított árkalkulációra és fájlalapú előzménykezelésre.

## Főbb funkciók
- **Foglalás létrehozása:** Tulajdonos (`Owner`), kisállat (`Pet`), kozmetikus (`Groomer`), időpont és kiválasztott szolgáltatások összekapcsolása egy `Booking` objektummá.
- **Állatjegyzetek (`Note`) kezelése:** Példányszintű jegyzetek hozzárendelése a `Pet` példányhoz (`1` / `0` kiválasztással).
- **Árkalkuláció (`Strategy` minta):** A `PricingStrategy` interfész több implementációja (pl. `FirstTimePricingStrategy`, `StandardPricingStrategy`, `LoyalPricingStrategy`) számolja ki a végösszeget a megadott bemeneti érték alapján, így a `Booking` osztály mentes a feltételes elágazásoktól.
- **Fájlból történő olvasás és írás:** A foglalások mentése és visszakeresése `java.nio.file.Files` segítségével (többek között a tulajdonos korábbi foglalásainak megszámolásához).

## Projekt felépítése (főbb osztályok)
- `Main` / `client/*` – Konzolos menü és bemenetbekérés egyetlen megosztott `Scanner` példánnyal (`nextLine()` és `Integer.parseInt` / `Double.parseDouble` használatával).
- `Booking` – A foglalás adatait és a kiszámított árat összefogó entitás.
- `Owner`, `Pet`, `Groomer`, `Service`, `Note` – A tartományi modellek.
- `PricingStrategy` és implementációi – Az árképzési stratégiák interfésze és konkrét változatai.
- `BookingFileWriter`, `BookingFileReader` – A foglalási előzmények fájlba írása és beolvasása (`UTF-8`).

## Futtatás
1. Fordítsd le a `.java` fájlokat a választott IDE-ben vagy parancssorból (`javac`).
2. Indítsd el a főbelépési pontot (`Main`), majd kövesd a konzolon megjelenő menüpontokat.
3. Az elmentett foglalások a `[bookings.txt]` fájlba kerülnek (a `BookingFileWriter` és `BookingFileReader` által használt útvonalon).

## Tervezési döntések és megoldott hibák
- **Egységes `Scanner` kezelés:** A bemeneti puffer és sorvége-karakterek (`\n`) okozta hibák elkerülése érdekében egyetlen `Scanner(System.in)` példány kerül továbbadásra.
- **Példányszintű adattagok:** A `Note` mezői példányszintűek, a `Pet` jegyzetei pedig a megfelelő setterrel (`this.notes = notes`, igen 15 percig ültem ez fölött valahogy, szóval büszke vagyok magamra) kerülnek beállításra, így nem írják felül egymást és nem maradnak `null` értéken.
- **Szétválasztott felelősségek:** A fájlírás/olvasás, az árképzési stratégia és a konzolos interakció külön osztályokban/metódusokban kapott helyet.
