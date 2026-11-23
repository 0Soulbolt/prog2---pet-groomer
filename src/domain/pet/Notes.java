package domain.pet;

import java.util.List;

public class Notes {
    public static List<Note> Notes() {
        return List.of(
                new Note("mattedCoat","Összetapadt szőrzet",40),
                new Note("sensitiveSkin","Érzékeny bőr",40),
                new Note("heavyUndercoat","Vastag alszőrzet",40),
                new Note("extraLongCoat","Hosszú szőrzet",40),
                new Note("needsBreaks","Szünetkre van szüksége",30),
                new Note("anxious", "Félénk", 20),
                new Note("affectionate", "Szeretetteljes",10),
                new Note("playful","Játékos",10),
                new Note("foodie","Éhenkórász", 20),
                new Note("communicative","Beszédes",10),
                new Note("overweight","Túlsúlyos", 10),
                new Note("underweight","Alultáplált", 15),
                new Note("hatesBaths","Utál fürdeni",30),
                new Note("Noisesensitive","Hangérzékeny",30),
                new Note("ExtraCare","Extra figyelmességet igényel", 30)
        );
    }
    public static Note findByName(String name) {
        return Notes().stream()
                .filter(service -> Note.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Ismeretlen tulajdonságnév: " + name));
    }

    public static int fieldCount() {
        int booleanFieldCount = 0;
        for (java.lang.reflect.Field field : Notes.class.getDeclaredFields()) {
            if (field.getType() == boolean.class) {
                booleanFieldCount++;
            }
        }
        return booleanFieldCount;
    }

    public int petNotesDuration(List<Note> notes) {
        int notesduration = 0;
        for (int i = 0; i < notes.size(); i++) {
            notesduration+=Note.getDurationExtra();
        }
        return notesduration;
    }
}
