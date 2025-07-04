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
        lamiDriverDetails.add(new LamiDriverDetails("Themba Zwane", "9903145123489", "073 867 3465", "thembzzwane@yahoo.com", true, "BK 54 LL GP", -29.8579, 31.0456, "South Beach, Durban", "not started"));
        lamiDriverDetails.add(new LamiDriverDetails("Sipho Dlamini", "8805123456789", "071 234 5678", "sipho.dlamini@gmail.com", true, "CA 12 AB GP", -33.9249, 18.4241, "Cape Town CBD", "en route"));
        lamiDriverDetails.add(new LamiDriverDetails("Nomsa Mthethwa", "9201012345089", "072 345 6789", "nomsa.m@gmail.com", true, "ND 45 XR GP", -29.8398, 31.0389, "Suncoast Casino, Durban", "completed"));
        lamiDriverDetails.add(new LamiDriverDetails("Thabo Ndlovu", "8504098765432", "074 456 7890", "thabo.ndlovu@ymail.com", false, "FS 99 PK GP", -29.1184, 26.2297, "Bloemfontein CBD", "not started"));
        lamiDriverDetails.add(new LamiDriverDetails("Lerato Khumalo", "9102234567890", "076 567 8901", "leratok@outlook.com", false, "GP 01 TW GP", -26.1086, 28.0567, "Sandton City, Johannesburg", "cancelled"));
        lamiDriverDetails.add(new LamiDriverDetails("Mandla Sibanda", "8903054321098", "073 000 1234", "mandla.sibanda@gmail.com", true, "LIM 22 VS GP", -23.9043, 29.4486, "Polokwane Mall", "not started"));
        lamiDriverDetails.add(new LamiDriverDetails("Thuli Mahlangu", "9007245678901", "072 111 2345", "thuli.mahlangu@webmail.co.za", true, "MP 33 AC GP", -25.4658, 30.9620, "Nelspruit Riverside Mall", "en route"));
        lamiDriverDetails.add(new LamiDriverDetails("Jabu Zulu", "8703056789012", "071 222 3456", "jabu.zulu@yahoo.com", true, "KZN 12 SD GP", -29.7275, 31.0847, "Umhlanga Rocks Beach", "completed"));
        lamiDriverDetails.add(new LamiDriverDetails("Zanele Ngubane", "9301023456789", "074 333 4567", "zanele.ngubane@gmail.com", true, "GP 76 ER GP", -25.7461, 28.1881, "Pretoria CBD", "cancelled"));
        lamiDriverDetails.add(new LamiDriverDetails("Boitumelo Modise", "9505148765432", "076 444 5678", "boitumelo.m@live.com", true, "NW 87 KA GP", -25.7844, 28.2750, "Menlyn Mall, Pretoria", "not started"));

        lamiDriverDetails.add(new LamiDriverDetails("Kagiso Molefe", "9012145678901", "072 777 1234", "kagiso.molefe@gmail.com", true, "FS 88 KL GP", -26.180388,  28.1172088, "Eastgate Mall, Johannesburg East", "not started"));
        lamiDriverDetails.add(new LamiDriverDetails("Lindiwe Dube", "9003123456789", "073 888 2345", "lindiwe.dube@hotmail.com", false, "GP 34 ML GP", -26.1451, 28.0416, "Rosebank Mall, Johannesburg", "completed"));
        lamiDriverDetails.add(new LamiDriverDetails("Sizwe Nkosi", "8801067890123", "074 999 3456", "sizwe.nkosi@ymail.com", true, "CA 11 QT WC", -33.9066, 18.4208, "V&A Waterfront, Cape Town", "en route"));
        lamiDriverDetails.add(new LamiDriverDetails("Thandeka Radebe", "9308198765432", "071 000 4567", "thandeka.r@gmail.com", true, "KZN 76 FE GP", -29.7261, 31.0648, "Gateway Theatre, Umhlanga", "cancelled"));
        lamiDriverDetails.add(new LamiDriverDetails("Neo Mokoena", "9502071234567", "076 111 5678", "neo.mokoena@outlook.com", false, "GP 88 ZY GP", -26.0249, 28.0106, "Montecasino, Fourways", "completed"));
        lamiDriverDetails.add(new LamiDriverDetails("Tshepo Baloyi", "9001013456789", "072 222 6789", "tshepo.baloyi@gmail.com", true, "MP 34 KT GP", -25.4658, 30.9620, "Mbombela (Nelspruit)", "not started"));
        lamiDriverDetails.add(new LamiDriverDetails("Ayanda Mokoetle", "9104057890123", "073 333 7890", "ayanda.mokoetle@yahoo.com", true, "NC 12 VR GP", -28.7381, 24.7635, "Kimberley Big Hole Museum", "en route"));
        lamiDriverDetails.add(new LamiDriverDetails("Bongani Mahlangu", "8906024567890", "074 444 8901", "bongani.m@gmail.com", true, "GP 21 XC GP", -25.7461, 28.1881, "Pretoria CBD", "completed"));
        lamiDriverDetails.add(new LamiDriverDetails("Karabo Pheko", "8803201234567", "071 555 9012", "karabo.pheko@webmail.co.za", false, "CA 77 QP WC", -33.8925, 18.5115, "Canal Walk, Cape Town", "cancelled"));
        lamiDriverDetails.add(new LamiDriverDetails("Nokuthula Madonsela", "9307070987654", "072 666 0123", "n.madonsela@gmail.com", true, "GP 04 YT GP", -25.7461, 28.1881, "Tshwane CBD", "not started"));

    }


    @Override
    public void run(String... args) throws Exception {
        lamiDriverRepository.deleteAll();
        lamiDriverRepository.saveAll(lamiDriverDetails);


    }
}
