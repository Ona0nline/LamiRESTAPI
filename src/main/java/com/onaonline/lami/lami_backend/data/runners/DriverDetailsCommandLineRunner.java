package com.onaonline.lami.lami_backend.data.runners;

import com.onaonline.lami.lami_backend.data.DriverDetails;
import com.onaonline.lami.lami_backend.data.repos.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DriverDetailsCommandLineRunner implements CommandLineRunner {

    private static List<DriverDetails> driverDetails = new ArrayList<>();
    private DriverRepository driverRepository;
    static {
//        Chat generated hardcoded values
        driverDetails.add(new DriverDetails(1L, "Themba Zwane", "9903145123489", "073 867 3465", "thembzzwane@yahoo.com", true, "Audi R8", "BK 54 LL GP", "Windhoek", "not started"));
        driverDetails.add(new DriverDetails(2L, "Sipho Dlamini", "8805123456789", "071 234 5678", "sipho.dlamini@gmail.com", true, "Toyota Corolla", "CA 12 AB GP", "Cape Town", "en route"));
        driverDetails.add(new DriverDetails(3L, "Nomsa Mthethwa", "9201012345089", "072 345 6789", "nomsa.m@gmail.com", true, "Honda Jazz", "ND 45 XR GP", "Durban", "completed"));
        driverDetails.add(new DriverDetails(4L, "Thabo Ndlovu", "8504098765432", "074 456 7890", "thabo.ndlovu@ymail.com", true, "BMW X5", "FS 99 PK GP", "Bloemfontein", "not started"));
        driverDetails.add(new DriverDetails(5L, "Lerato Khumalo", "9102234567890", "076 567 8901", "leratok@outlook.com", true, "Volkswagen Polo", "GP 01 TW GP", "Johannesburg", "cancelled"));
        driverDetails.add(new DriverDetails(6L, "Mandla Sibanda", "8903054321098", "073 000 1234", "mandla.sibanda@gmail.com", true, "Ford Ranger", "LIM 22 VS GP", "Polokwane", "not started"));
        driverDetails.add(new DriverDetails(7L, "Thuli Mahlangu", "9007245678901", "072 111 2345", "thuli.mahlangu@webmail.co.za", true, "Nissan Qashqai", "MP 33 AC GP", "Nelspruit", "en route"));
        driverDetails.add(new DriverDetails(8L, "Jabu Zulu", "8703056789012", "071 222 3456", "jabu.zulu@yahoo.com", true, "Mazda CX-5", "KZN 12 SD GP", "Durban", "completed"));
        driverDetails.add(new DriverDetails(9L, "Zanele Ngubane", "9301023456789", "074 333 4567", "zanele.ngubane@gmail.com", true, "Hyundai Tucson", "GP 76 ER GP", "Pretoria", "cancelled"));
        driverDetails.add(new DriverDetails(10L, "Boitumelo Modise", "9505148765432", "076 444 5678", "boitumelo.m@live.com", true, "Kia Rio", "NW 87 KA GP", "Mahikeng", "not started"));

        driverDetails.add(new DriverDetails(11L, "Kagiso Molefe", "9012145678901", "072 777 1234", "kagiso.molefe@gmail.com", true, "Toyota Yaris", "FS 88 KL GP", "Welkom", "not started"));
        driverDetails.add(new DriverDetails(12L, "Lindiwe Dube", "9003123456789", "073 888 2345", "lindiwe.dube@hotmail.com", true, "Ford EcoSport", "GP 34 ML GP", "Pretoria", "completed"));
        driverDetails.add(new DriverDetails(13L, "Sizwe Nkosi", "8801067890123", "074 999 3456", "sizwe.nkosi@ymail.com", true, "Hyundai Accent", "CA 11 QT WC", "Cape Town", "en route"));
        driverDetails.add(new DriverDetails(14L, "Thandeka Radebe", "9308198765432", "071 000 4567", "thandeka.r@gmail.com", true, "Mazda 2", "KZN 76 FE GP", "Durban", "cancelled"));
        driverDetails.add(new DriverDetails(15L, "Neo Mokoena", "9502071234567", "076 111 5678", "neo.mokoena@outlook.com", true, "Volkswagen T-Cross", "GP 88 ZY GP", "Johannesburg", "completed"));
        driverDetails.add(new DriverDetails(16L, "Tshepo Baloyi", "9001013456789", "072 222 6789", "tshepo.baloyi@gmail.com", true, "Nissan Almera", "MP 34 KT GP", "Mbombela", "not started"));
        driverDetails.add(new DriverDetails(17L, "Ayanda Mokoetle", "9104057890123", "073 333 7890", "ayanda.mokoetle@yahoo.com", true, "Honda Amaze", "NC 12 VR GP", "Kimberley", "en route"));
        driverDetails.add(new DriverDetails(18L, "Bongani Mahlangu", "8906024567890", "074 444 8901", "bongani.m@gmail.com", true, "Chevrolet Aveo", "GP 21 XC GP", "Pretoria", "completed"));
        driverDetails.add(new DriverDetails(19L, "Karabo Pheko", "8803201234567", "071 555 9012", "karabo.pheko@webmail.co.za", true, "Renault Sandero", "CA 77 QP WC", "Cape Town", "cancelled"));
        driverDetails.add(new DriverDetails(20L, "Nokuthula Madonsela", "9307070987654", "072 666 0123", "n.madonsela@gmail.com", true, "Hyundai i10", "GP 04 YT GP", "Tshwane", "not started"));
    }

    @Autowired
    public DriverDetailsCommandLineRunner(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        driverDetails.stream().forEach(driverDetail -> driverRepository.save(driverDetail));


    }
}
