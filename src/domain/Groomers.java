package domain;

import java.util.List;

public class Groomers {
    public static List<Groomer> Groomers() {
        return List.of(
                new Groomer(1, "Szaffi",10),
                new Groomer(2, "Vili",12),
                new Groomer(3, "Maja", 14),
                new Groomer(4, "Tihamér", 12)
        );
    }
}
