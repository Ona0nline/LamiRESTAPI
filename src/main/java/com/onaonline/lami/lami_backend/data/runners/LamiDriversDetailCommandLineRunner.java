package com.onaonline.lami.lami_backend.data.runners;

import com.onaonline.lami.lami_backend.data.details.LamiDriverDetails;
import com.onaonline.lami.lami_backend.data.repos.LamiDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LamiDriversDetailCommandLineRunner implements CommandLineRunner {

    private static List<LamiDriverDetails> lamiDriverDetails = new ArrayList<>();
    @Autowired
    private LamiDriverRepository lamiDriverRepository;
    static {
//        Chat generated hardcoded values
        lamiDriverDetails.add(new LamiDriverDetails( "Themba Zwane", "9903145123489", "073 867 3465", "thembzzwane@yahoo.com", true, "Audi R8", "BK 54 LL GP", "Windhoek", "not started"));
        lamiDriverDetails.add(new LamiDriverDetails( "Sipho Dlamini", "8805123456789", "071 234 5678", "sipho.dlamini@gmail.com", true, "Toyota Corolla", "CA 12 AB GP", "Cape Town", "en route"));
        lamiDriverDetails.add(new LamiDriverDetails( "Nomsa Mthethwa", "9201012345089", "072 345 6789", "nomsa.m@gmail.com", true, "Honda Jazz", "ND 45 XR GP", "Durban", "completed"));
        lamiDriverDetails.add(new LamiDriverDetails( "Thabo Ndlovu", "8504098765432", "074 456 7890", "thabo.ndlovu@ymail.com", false, "BMW X5", "FS 99 PK GP", "Bloemfontein", "not started"));
        lamiDriverDetails.add(new LamiDriverDetails ("Lerato Khumalo", "9102234567890", "076 567 8901", "leratok@outlook.com", false, "Volkswagen Polo", "GP 01 TW GP", "Johannesburg", "cancelled"));
        lamiDriverDetails.add(new LamiDriverDetails("Mandla Sibanda", "8903054321098", "073 000 1234", "mandla.sibanda@gmail.com", true, "Ford Ranger", "LIM 22 VS GP", "Polokwane", "not started"));
        lamiDriverDetails.add(new LamiDriverDetails("Thuli Mahlangu", "9007245678901", "072 111 2345", "thuli.mahlangu@webmail.co.za", true, "Nissan Qashqai", "MP 33 AC GP", "Nelspruit", "en route"));
        lamiDriverDetails.add(new LamiDriverDetails("Jabu Zulu", "8703056789012", "071 222 3456", "jabu.zulu@yahoo.com", true, "Mazda CX-5", "KZN 12 SD GP", "Durban", "completed"));
        lamiDriverDetails.add(new LamiDriverDetails("Zanele Ngubane", "9301023456789", "074 333 4567", "zanele.ngubane@gmail.com", true, "Hyundai Tucson", "GP 76 ER GP", "Pretoria", "cancelled"));
        lamiDriverDetails.add(new LamiDriverDetails( "Boitumelo Modise", "9505148765432", "076 444 5678", "boitumelo.m@live.com", true, "Kia Rio", "NW 87 KA GP", "Mahikeng", "not started"));

        lamiDriverDetails.add(new LamiDriverDetails( "Kagiso Molefe", "9012145678901", "072 777 1234", "kagiso.molefe@gmail.com", true, "Toyota Yaris", "FS 88 KL GP", "Welkom", "not started"));
        lamiDriverDetails.add(new LamiDriverDetails( "Lindiwe Dube", "9003123456789", "073 888 2345", "lindiwe.dube@hotmail.com", false, "Ford EcoSport", "GP 34 ML GP", "Pretoria", "completed"));
        lamiDriverDetails.add(new LamiDriverDetails( "Sizwe Nkosi", "8801067890123", "074 999 3456", "sizwe.nkosi@ymail.com", true, "Hyundai Accent", "CA 11 QT WC", "Cape Town", "en route"));
        lamiDriverDetails.add(new LamiDriverDetails( "Thandeka Radebe", "9308198765432", "071 000 4567", "thandeka.r@gmail.com", true, "Mazda 2", "KZN 76 FE GP", "Durban", "cancelled"));
        lamiDriverDetails.add(new LamiDriverDetails( "Neo Mokoena", "9502071234567", "076 111 5678", "neo.mokoena@outlook.com", false, "Volkswagen T-Cross", "GP 88 ZY GP", "Johannesburg", "completed"));
        lamiDriverDetails.add(new LamiDriverDetails( "Tshepo Baloyi", "9001013456789", "072 222 6789", "tshepo.baloyi@gmail.com", true, "Nissan Almera", "MP 34 KT GP", "Mbombela", "not started"));
        lamiDriverDetails.add(new LamiDriverDetails( "Ayanda Mokoetle", "9104057890123", "073 333 7890", "ayanda.mokoetle@yahoo.com", true, "Honda Amaze", "NC 12 VR GP", "Kimberley", "en route"));
        lamiDriverDetails.add(new LamiDriverDetails( "Bongani Mahlangu", "8906024567890", "074 444 8901", "bongani.m@gmail.com", true, "Chevrolet Aveo", "GP 21 XC GP", "Pretoria", "completed"));
        lamiDriverDetails.add(new LamiDriverDetails( "Karabo Pheko", "8803201234567", "071 555 9012", "karabo.pheko@webmail.co.za", false, "Renault Sandero", "CA 77 QP WC", "Cape Town", "cancelled"));
        lamiDriverDetails.add(new LamiDriverDetails( "Nokuthula Madonsela", "9307070987654", "072 666 0123", "n.madonsela@gmail.com", true, "Hyundai i10", "GP 04 YT GP", "Tshwane", "not started"));
    }


    @Override
    public void run(String... args) throws Exception {
        lamiDriverRepository.deleteAll();
        lamiDriverRepository.saveAll(lamiDriverDetails);


    }
}
