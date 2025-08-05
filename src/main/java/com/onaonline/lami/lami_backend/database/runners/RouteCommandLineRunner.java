package com.onaonline.lami.lami_backend.database.runners;

import com.onaonline.lami.lami_backend.database.details.RoutesDetails;
import com.onaonline.lami.lami_backend.database.repos.RoutesRepository;
import com.onaonline.lami.lami_backend.util.LatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RouteCommandLineRunner implements CommandLineRunner {

    @Autowired
    private RoutesRepository routeRepository;

        public static final List<RoutesDetails> ALL_ROUTES = Arrays.asList(
                // ================= GAUTENG (rankIds 1-3) =================
                // MTN Taxi Rank routes (rankId 1)
                new RoutesDetails(1L, "MTN Taxi Rank", -26.203049, 27.998500,
                        "Soweto Bara", -26.270759, 27.865854, 18,
                        Arrays.asList(
                                new LatLng(-26.203049, 27.9985), // Start
                                new LatLng(-26.210743, 27.985542),  // Point 1
                                new LatLng(-26.218289, 27.972876),  // Point 2
                                new LatLng(-26.225977, 27.960838),  // Point 3
                                new LatLng(-26.233561, 27.948210),  // Point 4
                                new LatLng(-26.241904, 27.935177),  // Point 5
                                new LatLng(-26.250810, 27.922543),  // Point 6
                                new LatLng(-26.258510, 27.908943),  // Point 7
                                new LatLng(-26.270759, 27.865854)   // End
                        )),

                new RoutesDetails(1L, "MTN Taxi Rank", -26.203049, 27.998500,
                        "Alexandra", -26.103312, 28.098998, 15,
                        Arrays.asList(
                                new LatLng(-26.203049, 27.998500),
                                new LatLng(-26.193615, 28.018124),
                                new LatLng(-26.184181, 28.037749),
                                new LatLng(-26.174746, 28.057373),
                                new LatLng(-26.165312, 28.076998),
                                new LatLng(-26.145746, 28.087373),
                                new LatLng(-26.126312, 28.097998),
                                new LatLng(-26.113312, 28.102998),
                                new LatLng(-26.103312, 28.098998)
                        )),

                // Bree Street Taxi Rank routes (rankId 2)
                new RoutesDetails(2L, "Bree Street Taxi Rank", -26.204103, 28.040251,
                        "Randburg CBD", -26.096764, 28.007264, 17,
                        Arrays.asList(
                                new LatLng(-26.204103, 28.040251),
                                new LatLng(-26.195103, 28.032251),
                                new LatLng(-26.186103, 28.024251),
                                new LatLng(-26.177103, 28.016251),
                                new LatLng(-26.168103, 28.008251),
                                new LatLng(-26.159103, 28.000251),
                                new LatLng(-26.150103, 27.992251),
                                new LatLng(-26.141103, 27.984251),
                                new LatLng(-26.096764, 28.007264)
                        )),

                new RoutesDetails(2L, "Bree Street Taxi Rank", -26.204103, 28.040251,
                        "Sandton City", -26.107571, 28.056721, 20,
                        Arrays.asList(
                                new LatLng(-26.204103, 28.040251),
                                new LatLng(-26.194103, 28.044251),
                                new LatLng(-26.184103, 28.048251),
                                new LatLng(-26.174103, 28.052251),
                                new LatLng(-26.164103, 28.056251),
                                new LatLng(-26.154103, 28.060251),
                                new LatLng(-26.144103, 28.064251),
                                new LatLng(-26.134103, 28.068251),
                                new LatLng(-26.107571, 28.056721)
                        )),

                // Johannesburg Park Station routes (rankId 3)
                new RoutesDetails(3L, "Johannesburg Park Station", -26.204898, 28.045128,
                        "Midrand", -25.996403, 28.137230, 25,
                        Arrays.asList(
                                new LatLng(-26.204898, 28.045128),
                                new LatLng(-26.184898, 28.065128),
                                new LatLng(-26.164898, 28.085128),
                                new LatLng(-26.144898, 28.105128),
                                new LatLng(-26.124898, 28.125128),
                                new LatLng(-26.104898, 28.145128),
                                new LatLng(-26.084898, 28.165128),
                                new LatLng(-26.064898, 28.185128),
                                new LatLng(-25.996403, 28.137230)
                        )),

                new RoutesDetails(3L, "Johannesburg Park Station", -26.204898, 28.045128,
                        "Pretoria CBD", -25.747875, 28.187923, 35,
                        Arrays.asList(
                                new LatLng(-26.204898, 28.045128),
                                new LatLng(-26.144898, 28.105128),
                                new LatLng(-26.084898, 28.165128),
                                new LatLng(-26.024898, 28.225128),
                                new LatLng(-25.964898, 28.285128),
                                new LatLng(-25.904898, 28.345128),
                                new LatLng(-25.844898, 28.405128),
                                new LatLng(-25.784898, 28.465128),
                                new LatLng(-25.747875, 28.187923)
                        )),

                // ================= WESTERN CAPE (rankIds 4-6) =================
                new RoutesDetails(4L, "Cape Town Station Deck", -33.925840, 18.425890,
                        "Khayelitsha", -34.038200, 18.673850, 25,
                        Arrays.asList(
                                new LatLng(-33.925840, 18.425890),
                                new LatLng(-33.935840, 18.455890),
                                new LatLng(-33.945840, 18.485890),
                                new LatLng(-33.955840, 18.515890),
                                new LatLng(-33.965840, 18.545890),
                                new LatLng(-33.975840, 18.575890),
                                new LatLng(-33.985840, 18.605890),
                                new LatLng(-34.015840, 18.635890),
                                new LatLng(-34.038200, 18.673850)
                        )),

                new RoutesDetails(4L, "Cape Town Station Deck", -33.925840, 18.425890,
                        "Mitchells Plain", -34.049460, 18.622390, 23,
                        Arrays.asList(
                                new LatLng(-33.925840, 18.425890),
                                new LatLng(-33.935840, 18.445890),
                                new LatLng(-33.945840, 18.465890),
                                new LatLng(-33.955840, 18.485890),
                                new LatLng(-33.965840, 18.505890),
                                new LatLng(-33.975840, 18.525890),
                                new LatLng(-33.985840, 18.545890),
                                new LatLng(-34.015840, 18.585890),
                                new LatLng(-34.049460, 18.622390)
                        )),

                new RoutesDetails(5L, "Bellville Taxi Rank", -33.898540, 18.629510,
                        "Parow", -33.899350, 18.601400, 14,
                        Arrays.asList(
                                new LatLng(-33.898540, 18.629510),
                                new LatLng(-33.898640, 18.619510),
                                new LatLng(-33.898740, 18.609510),
                                new LatLng(-33.898840, 18.599510),
                                new LatLng(-33.898940, 18.589510),
                                new LatLng(-33.899040, 18.579510),
                                new LatLng(-33.899140, 18.569510),
                                new LatLng(-33.899240, 18.559510),
                                new LatLng(-33.899350, 18.601400)
                        )),

                new RoutesDetails(6L, "Mitchells Plain Town Centre", -34.048680, 18.624390,
                        "Cape Town CBD", -33.924870, 18.424055, 30,
                        Arrays.asList(
                                new LatLng(-34.048680, 18.624390),
                                new LatLng(-34.038680, 18.604390),
                                new LatLng(-34.028680, 18.584390),
                                new LatLng(-34.018680, 18.564390),
                                new LatLng(-34.008680, 18.544390),
                                new LatLng(-33.998680, 18.524390),
                                new LatLng(-33.988680, 18.504390),
                                new LatLng(-33.968680, 18.464390),
                                new LatLng(-33.924870, 18.424055)
                        )),

                // ================= KWAZULU-NATAL (rankIds 7-9) =================
                new RoutesDetails(7L, "Warwick Junction", -29.853270, 31.008900,
                        "Umlazi", -29.964140, 30.870830, 18,
                        Arrays.asList(
                                new LatLng(-29.853270, 31.008900),
                                new LatLng(-29.863270, 30.998900),
                                new LatLng(-29.873270, 30.988900),
                                new LatLng(-29.883270, 30.978900),
                                new LatLng(-29.893270, 30.968900),
                                new LatLng(-29.903270, 30.958900),
                                new LatLng(-29.923270, 30.938900),
                                new LatLng(-29.943270, 30.918900),
                                new LatLng(-29.964140, 30.870830)
                        )),

                new RoutesDetails(7L, "Warwick Junction", -29.853270, 31.008900,
                        "KwaMashu", -29.718260, 30.990750, 17,
                        Arrays.asList(
                                new LatLng(-29.853270, 31.008900),
                                new LatLng(-29.833270, 31.008900),
                                new LatLng(-29.813270, 31.008900),
                                new LatLng(-29.793270, 31.008900),
                                new LatLng(-29.773270, 31.008900),
                                new LatLng(-29.753270, 31.008900),
                                new LatLng(-29.733270, 31.008900),
                                new LatLng(-29.723270, 30.998900),
                                new LatLng(-29.718260, 30.990750)
                        )),

                new RoutesDetails(8L, "Bridge City Taxi Rank", -29.698790, 30.989290,
                        "Durban CBD", -29.858680, 31.021840, 16,
                        Arrays.asList(
                                new LatLng(-29.698790, 30.989290),
                                new LatLng(-29.718790, 30.999290),
                                new LatLng(-29.738790, 31.009290),
                                new LatLng(-29.758790, 31.019290),
                                new LatLng(-29.778790, 31.029290),
                                new LatLng(-29.798790, 31.039290),
                                new LatLng(-29.818790, 31.049290),
                                new LatLng(-29.838790, 31.029290),
                                new LatLng(-29.858680, 31.021840)
                        )),

                new RoutesDetails(9L, "Pinetown CBD Rank", -29.818760, 30.865040,
                        "New Germany", -29.821960, 30.889750, 15,
                        Arrays.asList(
                                new LatLng(-29.818760, 30.865040),
                                new LatLng(-29.819760, 30.870040),
                                new LatLng(-29.820760, 30.875040),
                                new LatLng(-29.821260, 30.880040),
                                new LatLng(-29.821760, 30.885040),
                                new LatLng(-29.821860, 30.887040),
                                new LatLng(-29.821960, 30.889040),
                                new LatLng(-29.821960, 30.889750)
                        )),

                // ================= EASTERN CAPE (rankIds 10-12) =================
                new RoutesDetails(10L, "North End Taxi Rank", -33.951640, 25.602510,
                        "Motherwell", -33.832030, 25.621700, 22,
                        Arrays.asList(
                                new LatLng(-33.951640, 25.602510),
                                new LatLng(-33.941640, 25.605510),
                                new LatLng(-33.931640, 25.608510),
                                new LatLng(-33.921640, 25.611510),
                                new LatLng(-33.911640, 25.614510),
                                new LatLng(-33.891640, 25.617510),
                                new LatLng(-33.871640, 25.619510),
                                new LatLng(-33.851640, 25.620510),
                                new LatLng(-33.832030, 25.621700)
                        )),

                new RoutesDetails(11L, "Mdantsane Taxi Rank", -32.943360, 27.788020,
                        "East London CBD", -33.015290, 27.911630, 20,
                        Arrays.asList(
                                new LatLng(-32.943360, 27.788020),
                                new LatLng(-32.953360, 27.808020),
                                new LatLng(-32.963360, 27.828020),
                                new LatLng(-32.973360, 27.848020),
                                new LatLng(-32.983360, 27.868020),
                                new LatLng(-32.993360, 27.888020),
                                new LatLng(-33.003360, 27.898020),
                                new LatLng(-33.009290, 27.905630),
                                new LatLng(-33.015290, 27.911630)
                        )),

                new RoutesDetails(12L, "Uitenhage Taxi Rank", -33.757690, 25.401510,
                        "Port Elizabeth CBD", -33.960800, 25.602180, 18,
                        Arrays.asList(
                                new LatLng(-33.757690, 25.401510),
                                new LatLng(-33.767690, 25.421510),
                                new LatLng(-33.777690, 25.441510),
                                new LatLng(-33.787690, 25.461510),
                                new LatLng(-33.807690, 25.481510),
                                new LatLng(-33.827690, 25.501510),
                                new LatLng(-33.847690, 25.521510),
                                new LatLng(-33.887690, 25.551510),
                                new LatLng(-33.960800, 25.602180)
                        )),

                // ================= FREE STATE (rankIds 13-15) =================
                new RoutesDetails(13L, "Bloemfontein CBD Rank", -29.117430, 26.215470,
                        "Botshabelo", -29.234380, 26.716620, 25,
                        Arrays.asList(
                                new LatLng(-29.117430, 26.215470),
                                new LatLng(-29.127430, 26.255470),
                                new LatLng(-29.137430, 26.295470),
                                new LatLng(-29.147430, 26.335470),
                                new LatLng(-29.157430, 26.375470),
                                new LatLng(-29.177430, 26.455470),
                                new LatLng(-29.197430, 26.535470),
                                new LatLng(-29.217430, 26.615470),
                                new LatLng(-29.234380, 26.716620)
                        )),

                new RoutesDetails(14L, "Welkom Taxi Rank", -27.994550, 26.720460,
                        "Thabong", -28.008600, 26.791620, 15,
                        Arrays.asList(
                                new LatLng(-27.994550, 26.720460),
                                new LatLng(-27.997550, 26.730460),
                                new LatLng(-28.000550, 26.740460),
                                new LatLng(-28.003550, 26.750460),
                                new LatLng(-28.005550, 26.760460),
                                new LatLng(-28.006550, 26.770460),
                                new LatLng(-28.007550, 26.780460),
                                new LatLng(-28.008050, 26.786460),
                                new LatLng(-28.008600, 26.791620)
                        )),

                new RoutesDetails(15L, "Botshabelo Taxi Rank", -29.233920, 26.714920,
                        "Bloemfontein CBD", -29.117430, 26.215470, 25,
                        Arrays.asList(
                                new LatLng(-29.233920, 26.714920),
                                new LatLng(-29.223920, 26.674920),
                                new LatLng(-29.213920, 26.634920),
                                new LatLng(-29.203920, 26.594920),
                                new LatLng(-29.193920, 26.554920),
                                new LatLng(-29.183920, 26.514920),
                                new LatLng(-29.173920, 26.474920),
                                new LatLng(-29.153920, 26.394920),
                                new LatLng(-29.117430, 26.215470)
                        )),

                // ================= LIMPOPO (rankIds 16-18) =================
                new RoutesDetails(16L, "Polokwane Taxi Rank", -23.904500, 29.468850,
                        "Seshego", -23.870190, 29.386180, 12,
                        Arrays.asList(
                                new LatLng(-23.904500, 29.468850),
                                new LatLng(-23.899500, 29.458850),
                                new LatLng(-23.894500, 29.448850),
                                new LatLng(-23.889500, 29.438850),
                                new LatLng(-23.884500, 29.428850),
                                new LatLng(-23.879500, 29.418850),
                                new LatLng(-23.874500, 29.408850),
                                new LatLng(-23.872190, 29.397180),
                                new LatLng(-23.870190, 29.386180)
                        )),

                new RoutesDetails(17L, "Thohoyandou Taxi Rank", -22.974230, 30.453580,
                        "Sibasa", -22.950760, 30.471490, 10,
                        Arrays.asList(
                                new LatLng(-22.974230, 30.453580),
                                new LatLng(-22.970230, 30.457580),
                                new LatLng(-22.966230, 30.461580),
                                new LatLng(-22.962230, 30.465580),
                                new LatLng(-22.958230, 30.469580),
                                new LatLng(-22.954230, 30.471580),
                                new LatLng(-22.952230, 30.471580),
                                new LatLng(-22.951230, 30.471580),
                                new LatLng(-22.950760, 30.471490)
                        )),

                new RoutesDetails(18L, "Mokopane Taxi Rank", -24.194100, 29.009150,
                        "Mahwelereng", -24.164820, 28.980140, 14,
                        Arrays.asList(
                                new LatLng(-24.194100, 29.009150),
                                new LatLng(-24.189100, 29.004150),
                                new LatLng(-24.184100, 28.999150),
                                new LatLng(-24.179100, 28.994150),
                                new LatLng(-24.174100, 28.989150),
                                new LatLng(-24.169100, 28.984150),
                                new LatLng(-24.166820, 28.982140),
                                new LatLng(-24.165820, 28.981140),
                                new LatLng(-24.164820, 28.980140)
                        )),

                // ================= MPUMALANGA (rankIds 19-21) =================
                new RoutesDetails(19L, "Nelspruit CBD Rank", -25.474480, 30.970020,
                        "KaNyamazane", -25.490570, 31.048180, 17,
                        Arrays.asList(
                                new LatLng(-25.474480, 30.970020),
                                new LatLng(-25.478480, 30.980020),
                                new LatLng(-25.482480, 30.990020),
                                new LatLng(-25.484480, 31.000020),
                                new LatLng(-25.486480, 31.010020),
                                new LatLng(-25.488480, 31.020020),
                                new LatLng(-25.489480, 31.030020),
                                new LatLng(-25.490480, 31.040020),
                                new LatLng(-25.490570, 31.048180)
                        )),

                new RoutesDetails(20L, "Emalahleni Taxi Rank", -25.875150, 29.233230,
                        "Ogies", -26.001290, 29.049950, 20,
                        Arrays.asList(
                                new LatLng(-25.875150, 29.233230),
                                new LatLng(-25.885150, 29.213230),
                                new LatLng(-25.895150, 29.193230),
                                new LatLng(-25.905150, 29.173230),
                                new LatLng(-25.925150, 29.153230),
                                new LatLng(-25.945150, 29.133230),
                                new LatLng(-25.965150, 29.113230),
                                new LatLng(-25.985150, 29.093230),
                                new LatLng(-26.001290, 29.049950)
                        )),

                new RoutesDetails(21L, "Secunda Taxi Rank", -26.516130, 29.203370,
                        "Evander", -26.519430, 29.096390, 15,
                        Arrays.asList(
                                new LatLng(-26.516130, 29.203370),
                                new LatLng(-26.516530, 29.183370),
                                new LatLng(-26.516930, 29.163370),
                                new LatLng(-26.517330, 29.143370),
                                new LatLng(-26.517730, 29.123370),
                                new LatLng(-26.518130, 29.113370),
                                new LatLng(-26.518530, 29.103370),
                                new LatLng(-26.518930, 29.099370),
                                new LatLng(-26.519430, 29.096390)
                        )),

                // ================= NORTHERN CAPE (rankIds 22-24) =================
                new RoutesDetails(22L, "Kimberley Taxi Rank", -28.738300, 24.763430,
                        "Galeshewe", -28.726210, 24.738160, 14,
                        Arrays.asList(
                                new LatLng(-28.738300, 24.763430),
                                new LatLng(-28.736300, 24.758430),
                                new LatLng(-28.734300, 24.753430),
                                new LatLng(-28.732300, 24.748430),
                                new LatLng(-28.730300, 24.743430),
                                new LatLng(-28.728300, 24.740430),
                                new LatLng(-28.727210, 24.739160),
                                new LatLng(-28.726710, 24.738660),
                                new LatLng(-28.726210, 24.738160)
                        )),

                new RoutesDetails(23L, "Upington Taxi Rank", -28.452730, 21.256510,
                        "Keimoes", -28.703010, 20.980300, 25,
                        Arrays.asList(
                                new LatLng(-28.452730, 21.256510),
                                new LatLng(-28.482730, 21.226510),
                                new LatLng(-28.512730, 21.196510),
                                new LatLng(-28.542730, 21.166510),
                                new LatLng(-28.572730, 21.136510),
                                new LatLng(-28.602730, 21.106510),
                                new LatLng(-28.632730, 21.076510),
                                new LatLng(-28.662730, 21.046510),
                                new LatLng(-28.703010, 20.980300)
                        )),

                new RoutesDetails(24L, "Springbok Taxi Rank", -29.664490, 17.886740,
                        "Okiep", -29.630170, 17.875640, 20,
                        Arrays.asList(
                                new LatLng(-29.664490, 17.886740),
                                new LatLng(-29.659490, 17.884740),
                                new LatLng(-29.654490, 17.882740),
                                new LatLng(-29.649490, 17.880740),
                                new LatLng(-29.644490, 17.878740),
                                new LatLng(-29.639490, 17.876740),
                                new LatLng(-29.634490, 17.875740),
                                new LatLng(-29.632170, 17.875640),
                                new LatLng(-29.630170, 17.875640)
                        )),

                // ================= NORTH WEST (rankIds 25-27) =================
                new RoutesDetails(25L, "Mafikeng Taxi Rank", -25.865750, 25.644150,
                        "Mmabatho", -25.852560, 25.621390, 10,
                        Arrays.asList(
                                new LatLng(-25.865750, 25.644150),
                                new LatLng(-25.863750, 25.639150),
                                new LatLng(-25.861750, 25.634150),
                                new LatLng(-25.859750, 25.629150),
                                new LatLng(-25.857750, 25.624150),
                                new LatLng(-25.855750, 25.622150),
                                new LatLng(-25.854560, 25.621390),
                                new LatLng(-25.853560, 25.621390),
                                new LatLng(-25.852560, 25.621390)
                        )),

                new RoutesDetails(26L, "Rustenburg Taxi Rank", -25.672130, 27.241720,
                        "Tlhabane", -25.669820, 27.206700, 12,
                        Arrays.asList(
                                new LatLng(-25.672130, 27.241720),
                                new LatLng(-25.671130, 27.231720),
                                new LatLng(-25.670130, 27.221720),
                                new LatLng(-25.669930, 27.211720),
                                new LatLng(-25.669830, 27.206720),
                                new LatLng(-25.669820, 27.206700)
                        )),

                new RoutesDetails(27L, "Klerksdorp Taxi Rank", -26.871180, 26.664220,
                        "Jouberton", -26.826000, 26.617080, 15,
                        Arrays.asList(
                                new LatLng(-26.871180, 26.664220),
                                new LatLng(-26.861180, 26.654220),
                                new LatLng(-26.851180, 26.644220),
                                new LatLng(-26.841180, 26.634220),
                                new LatLng(-26.831180, 26.624220),
                                new LatLng(-26.828000, 26.620080),
                                new LatLng(-26.826000, 26.617080)
                        )),

                // ================= CROSS-PROVINCE MAJOR ROUTES =================
                new RoutesDetails(1L, "MTN Taxi Rank", -26.203049, 27.998500,
                        "Pretoria CBD", -25.746111, 28.188056, 35,
                        Arrays.asList(
                                new LatLng(-26.203049, 27.998500),
                                new LatLng(-26.153049, 28.048500),
                                new LatLng(-26.103049, 28.098500),
                                new LatLng(-26.053049, 28.148500),
                                new LatLng(-25.993049, 28.178500),
                                new LatLng(-25.893049, 28.188500),
                                new LatLng(-25.793049, 28.188500),
                                new LatLng(-25.746111, 28.188056)
                        )),

                new RoutesDetails(4L, "Cape Town Station Deck", -33.925840, 18.425890,
                        "Somerset West", -34.079020, 18.856130, 40,
                        Arrays.asList(
                                new LatLng(-33.925840, 18.425890),
                                new LatLng(-33.945840, 18.455890),
                                new LatLng(-33.965840, 18.485890),
                                new LatLng(-33.985840, 18.515890),
                                new LatLng(-34.005840, 18.545890),
                                new LatLng(-34.025840, 18.575890),
                                new LatLng(-34.045840, 18.605890),
                                new LatLng(-34.065840, 18.635890),
                                new LatLng(-34.079020, 18.856130)
                        )),

                new RoutesDetails(7L, "Warwick Junction", -29.853270, 31.008900,
                        "Pietermaritzburg", -29.603560, 30.379010, 40,
                        Arrays.asList(
                                new LatLng(-29.853270, 31.008900),
                                new LatLng(-29.803270, 30.908900),
                                new LatLng(-29.753270, 30.808900),
                                new LatLng(-29.703270, 30.708900),
                                new LatLng(-29.653270, 30.608900),
                                new LatLng(-29.623270, 30.508900),
                                new LatLng(-29.613560, 30.408900),
                                new LatLng(-29.603560, 30.379010)
                        )),

                new RoutesDetails(13L, "Bloemfontein CBD Rank", -29.117430, 26.215470,
                        "Johannesburg Park Station", -26.204898, 28.045128, 45,
                        Arrays.asList(
                                new LatLng(-29.117430, 26.215470),
                                new LatLng(-28.917430, 26.415470),
                                new LatLng(-28.717430, 26.615470),
                                new LatLng(-28.517430, 26.815470),
                                new LatLng(-28.317430, 27.015470),
                                new LatLng(-27.917430, 27.415470),
                                new LatLng(-27.517430, 27.815470),
                                new LatLng(-26.904898, 28.045128)
                        ))
        );



    @Override
    public void run(String... args) throws Exception {
        routeRepository.deleteAll();
        routeRepository.saveAll(ALL_ROUTES);
    }

}

