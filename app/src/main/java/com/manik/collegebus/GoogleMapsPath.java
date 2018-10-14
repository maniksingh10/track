package com.manik.collegebus;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.database.collection.LLRBNode;
import com.manik.collegebus.DirectionsJSONParser;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GoogleMapsPath {

    public GoogleMap map;


    public GoogleMapsPath(GoogleMap map){
        this.map = map;

        String fixdata = "{\n" +
                "   \"geocoded_waypoints\" : [\n" +
                "      {\n" +
                "         \"geocoder_status\" : \"OK\",\n" +
                "         \"place_id\" : \"ChIJO2MZND4DDTkRiEDWGKCwhDs\",\n" +
                "         \"types\" : [\n" +
                "            \"bus_station\",\n" +
                "            \"establishment\",\n" +
                "            \"point_of_interest\",\n" +
                "            \"transit_station\"\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"geocoder_status\" : \"OK\",\n" +
                "         \"place_id\" : \"ChIJ3w6Ixz8DDTkR0LsQIdNlyNU\",\n" +
                "         \"types\" : [ \"establishment\", \"point_of_interest\" ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"geocoder_status\" : \"OK\",\n" +
                "         \"place_id\" : \"ChIJm6v1X1wDDTkRmSub0hWJ3FY\",\n" +
                "         \"types\" : [ \"establishment\", \"point_of_interest\", \"store\" ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"geocoder_status\" : \"OK\",\n" +
                "         \"place_id\" : \"ChIJ55B-X2EDDTkRex6GmjlCXSY\",\n" +
                "         \"types\" : [ \"establishment\", \"food\", \"point_of_interest\", \"restaurant\" ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"geocoder_status\" : \"OK\",\n" +
                "         \"place_id\" : \"ChIJpcPStJgEDTkRlsBCARbHcDk\",\n" +
                "         \"types\" : [ \"establishment\", \"point_of_interest\" ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"geocoder_status\" : \"OK\",\n" +
                "         \"place_id\" : \"ChIJv5lXjlUbDTkRk-8TAKETc1o\",\n" +
                "         \"types\" : [ \"street_address\" ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"geocoder_status\" : \"OK\",\n" +
                "         \"place_id\" : \"ChIJTwz3orMEDTkRZ_X4mQSO9g8\",\n" +
                "         \"types\" : [ \"street_address\" ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"geocoder_status\" : \"OK\",\n" +
                "         \"place_id\" : \"ChIJQ-fipb8EDTkR65sc9Y8YzjQ\",\n" +
                "         \"types\" : [ \"clothing_store\", \"establishment\", \"point_of_interest\", \"store\" ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"geocoder_status\" : \"OK\",\n" +
                "         \"place_id\" : \"ChIJY8UKd5MEDTkRQIHq2AAPsqg\",\n" +
                "         \"types\" : [ \"establishment\", \"point_of_interest\" ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"geocoder_status\" : \"OK\",\n" +
                "         \"place_id\" : \"ChIJCwR62HIEDTkRo5WXrCi7toM\",\n" +
                "         \"types\" : [ \"premise\" ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"geocoder_status\" : \"OK\",\n" +
                "         \"place_id\" : \"ChIJ-c6kssAODTkRkLUVgYNKKXA\",\n" +
                "         \"types\" : [ \"route\" ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"geocoder_status\" : \"OK\",\n" +
                "         \"place_id\" : \"ChIJv74o54sLDTkR0f-lxFbB78E\",\n" +
                "         \"types\" : [ \"establishment\", \"library\", \"point_of_interest\" ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"geocoder_status\" : \"OK\",\n" +
                "         \"place_id\" : \"ChIJ12IKX4kLDTkRp7RgzI5mdpg\",\n" +
                "         \"types\" : [ \"premise\" ]\n" +
                "      }\n" +
                "   ],\n" +
                "   \"routes\" : [\n" +
                "      {\n" +
                "         \"bounds\" : {\n" +
                "            \"northeast\" : {\n" +
                "               \"lat\" : 28.6896098,\n" +
                "               \"lng\" : 77.1291337\n" +
                "            },\n" +
                "            \"southwest\" : {\n" +
                "               \"lat\" : 28.6084249,\n" +
                "               \"lng\" : 76.8839966\n" +
                "            }\n" +
                "         },\n" +
                "         \"copyrights\" : \"Map data ©2018 Google\",\n" +
                "         \"legs\" : [\n" +
                "            {\n" +
                "               \"distance\" : {\n" +
                "                  \"text\" : \"43.0 km\",\n" +
                "                  \"value\" : 42986\n" +
                "               },\n" +
                "               \"duration\" : {\n" +
                "                  \"text\" : \"1 hour 28 mins\",\n" +
                "                  \"value\" : 5287\n" +
                "               },\n" +
                "               \"end_address\" : \"MCA Block, Sector 3A, Bahadurgarh, Haryana 124507, India\",\n" +
                "               \"end_location\" : {\n" +
                "                  \"lat\" : 28.6876122,\n" +
                "                  \"lng\" : 76.88894719999999\n" +
                "               },\n" +
                "               \"start_address\" : \"Mayapuri Crossing, Block WH, Mayapuri Industrial Area Phase I, Mayapuri, Delhi, 110064, India\",\n" +
                "               \"start_location\" : {\n" +
                "                  \"lat\" : 28.6370296,\n" +
                "                  \"lng\" : 77.1291337\n" +
                "               },\n" +
                "               \"steps\" : [\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"1.0 km\",\n" +
                "                        \"value\" : 982\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"2 mins\",\n" +
                "                        \"value\" : 141\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6297792,\n" +
                "                        \"lng\" : 77.12376239999999\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Head \\u003cb\\u003esouthwest\\u003c/b\\u003e on \\u003cb\\u003eSatguru Ram Singh Rd\\u003c/b\\u003e toward \\u003cb\\u003eMahashaya Vasudev Marg\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by the park (on the right)\\u003c/div\\u003e\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"mdxmDahwuMJZLVLRHNHHJHJHPJHDF@FDJBH@FBF@L@TBR?P@`@@t@D\\\\DXFFB`@NPHLHd@ZJHZVb@\\\\x@r@jBxATPz@r@JH^\\\\lA`A^\\\\ZXb@\\\\pB|AVRfA`AxAlAlA`A`@Z\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6370296,\n" +
                "                        \"lng\" : 77.1291337\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"2.5 km\",\n" +
                "                        \"value\" : 2453\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"9 mins\",\n" +
                "                        \"value\" : 513\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6411183,\n" +
                "                        \"lng\" : 77.1076592\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Turn \\u003cb\\u003eright\\u003c/b\\u003e onto \\u003cb\\u003eMahakavi Goswami Tulsidas Marg\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Shiv Shakti Mandir (on the left in 2.0&nbsp;km)\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-right\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"cwvmDofvuMDBFDKRwAzBm@dAOPKLUZABA@ADAHAHAT?XAX?V?X?n@At@?N?N?HAH?p@AP?`@?b@?N?N?d@?X?T?r@Ar@?X?V?VAZ?LAh@?L?TAt@ArAAdBAjBAxA?bA?R?j@CjC?rCAnA?@Et@AFMx@EVOn@KZGN]f@YZ_@l@?LCH?@A@?@A??@A??@A?A@A??@A?A?A?A?A?Y\\\\iBhCCD[`@GJKLCBMDCBUF_@FSDa@Jy@Ru@RKBs@RQBA@]Ra@ZGFq@r@_@`@c@h@oApAOLg@f@s@j@MFIDSBG@K@I@g@?w@AgA?s@?Q?qAAi@?qAAqAAm@?Y@a@?o@?o@?m@?_A?g@?YH\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6297792,\n" +
                "                        \"lng\" : 77.12376239999999\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.8 km\",\n" +
                "                        \"value\" : 819\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"2 mins\",\n" +
                "                        \"value\" : 143\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6383745,\n" +
                "                        \"lng\" : 77.1000828\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e onto \\u003cb\\u003eNajafgarh Rd\\u003c/b\\u003e/\\u003cb\\u003eShivaji Marg\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Central Bank Of India (on the left in 450&nbsp;m)\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"_~xmD{asuMGDGFEFEFCDAD?DANX~@Vv@|@hC\\\\`AL`@fAvD`AfDDLf@pBb@`BXfATv@d@bBJ\\\\DNl@fBz@hC\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6411183,\n" +
                "                        \"lng\" : 77.1076592\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.4 km\",\n" +
                "                        \"value\" : 358\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 52\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6368212,\n" +
                "                        \"lng\" : 77.09687409999999\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Continue straight past Bank of India to stay on \\u003cb\\u003eNajafgarh Rd\\u003c/b\\u003e/\\u003cb\\u003eShivaji Marg\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Metro Pillar Number 499 (on the right)\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"straight\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"ylxmDorquMl@pBjDvIhAtCFNHP\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6383745,\n" +
                "                        \"lng\" : 77.1000828\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"2.4 km\",\n" +
                "                        \"value\" : 2362\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"7 mins\",\n" +
                "                        \"value\" : 433\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6173297,\n" +
                "                        \"lng\" : 77.10573429999999\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"At \\u003cb\\u003eTilak Nagar Round About\\u003c/b\\u003e, take the \\u003cb\\u003e2nd\\u003c/b\\u003e exit onto \\u003cb\\u003eJail Rd\\u003c/b\\u003e/\\u003cb\\u003eShaheed Bhagat Singh Marg\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by the gas station (on the left in 1.1&nbsp;km)\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"roundabout-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"ccxmDm~puMJILCLCL?L@LBLFJFBBBBB@BBBDBB@BBDTG@?h@On@SRITIl@Uh@S`@KhA]rC}@^MJGFAx@Wj@U^Op@SZKl@Sh@QZKLE\\\\M`@K`@M`@Mb@ORILEl@Qj@Q\\\\KDC\\\\KXMZI|@[xBu@~Ak@fCu@j@QJE~CeAnE}ATKr@QRGl@S\\\\Mr@Sv@Yd@QvAg@PGlCy@l@Wf@UXOtAw@l@Yd@YPKp@]^S|FyCd@WvBiApBcAz@e@NI`Ai@\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6368212,\n" +
                "                        \"lng\" : 77.09687409999999\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.3 km\",\n" +
                "                        \"value\" : 324\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 59\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6148671,\n" +
                "                        \"lng\" : 77.1075049\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Slight \\u003cb\\u003eleft\\u003c/b\\u003e toward \\u003cb\\u003eSewa Marg\\u003c/b\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-slight-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"iitmDyuruMRSLM\\\\Q~EoCj@_@bAs@p@g@h@a@\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6173297,\n" +
                "                        \"lng\" : 77.10573429999999\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.9 km\",\n" +
                "                        \"value\" : 869\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"3 mins\",\n" +
                "                        \"value\" : 166\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6086669,\n" +
                "                        \"lng\" : 77.1025642\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Turn \\u003cb\\u003eright\\u003c/b\\u003e onto \\u003cb\\u003eSewa Marg\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Management Education &amp; Research Institute (MERI) (on the right in 700&nbsp;m)\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-right\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"}ysmD{`suMLMX`@Zl@f@r@hAfBR\\\\FJFJPX`BfCFHTZPZRRDDBBFFJFHBRJdAb@fAd@xCrAD@fChAx@^hCfAfAf@fAj@\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6148671,\n" +
                "                        \"lng\" : 77.1075049\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"1.3 km\",\n" +
                "                        \"value\" : 1294\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"4 mins\",\n" +
                "                        \"value\" : 230\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6117637,\n" +
                "                        \"lng\" : 77.09041689999999\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Turn \\u003cb\\u003eright\\u003c/b\\u003e after Aditi Apartments (on the left)\",\n" +
                "                     \"maneuver\" : \"turn-right\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"esrmD_bruM\\\\LRHMV_@lACDYv@M\\\\Qh@AFOd@Ol@ELENCPA@CRAV?\\\\?\\\\?@?VD^H|AJfABTJdBBb@Bz@?v@A^EZCVK^KXUl@mAtDkApDoAxDENI`@UhAUvAQv@Ql@{AtEGRe@pASd@GR\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6086669,\n" +
                "                        \"lng\" : 77.1025642\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.3 km\",\n" +
                "                        \"value\" : 260\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 37\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6126919,\n" +
                "                        \"lng\" : 77.08797629999999\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Slight \\u003cb\\u003eleft\\u003c/b\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-slight-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"ofsmDcvouMO|@On@]nA_AjCc@tASz@CJ\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6117637,\n" +
                "                        \"lng\" : 77.09041689999999\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"87 m\",\n" +
                "                        \"value\" : 87\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 14\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6130179,\n" +
                "                        \"lng\" : 77.08716579999999\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Continue straight\",\n" +
                "                     \"maneuver\" : \"straight\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"ilsmD{fouMg@nAQv@CLCJ\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6126919,\n" +
                "                        \"lng\" : 77.08797629999999\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.2 km\",\n" +
                "                        \"value\" : 191\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 33\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6137824,\n" +
                "                        \"lng\" : 77.08570469999999\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"At \\u003cb\\u003eDabri Crossing Roundabout\\u003c/b\\u003e, take the \\u003cb\\u003e1st\\u003c/b\\u003e exit\",\n" +
                "                     \"maneuver\" : \"roundabout-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"knsmDyaouMFLFPDP@T?@CTERGLILMHGBC@O@A?SXq@h@OZQb@\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6130179,\n" +
                "                        \"lng\" : 77.08716579999999\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.1 km\",\n" +
                "                        \"value\" : 119\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 26\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6137698,\n" +
                "                        \"lng\" : 77.08663079999999\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Make a \\u003cb\\u003eU-turn\\u003c/b\\u003e\",\n" +
                "                     \"maneuver\" : \"uturn-right\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"cssmDsxnuMI?G?KAGEGGCGCI?K?Ad@{APm@\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6137824,\n" +
                "                        \"lng\" : 77.08570469999999\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.9 km\",\n" +
                "                        \"value\" : 917\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"3 mins\",\n" +
                "                        \"value\" : 169\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6216865,\n" +
                "                        \"lng\" : 77.08885359999999\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e onto \\u003cb\\u003eMajor P Srikumar Marg\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Janakpuri Super Speciality Hospital (on the right in 850&nbsp;m)\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"assmDm~nuMUMaB{@o@W}@a@KEYMaEqAQGsEmA_B[eAUUEOCSCiAEg@CgBIoCOkACe@AcCM{@C\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6137698,\n" +
                "                        \"lng\" : 77.08663079999999\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.1 km\",\n" +
                "                        \"value\" : 97\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 26\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6217697,\n" +
                "                        \"lng\" : 77.0878666\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e onto \\u003cb\\u003eLal Sai Mandir Marg\\u003c/b\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"qdumDilouMInCEr@\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6216865,\n" +
                "                        \"lng\" : 77.08885359999999\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"1.2 km\",\n" +
                "                        \"value\" : 1241\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"4 mins\",\n" +
                "                        \"value\" : 232\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6310748,\n" +
                "                        \"lng\" : 77.08165049999999\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Turn \\u003cb\\u003eright\\u003c/b\\u003e onto \\u003cb\\u003eProfessor Joginder Singh Marg\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Standard Chartered New Delhi - Janakpuri Branch (on the right in 1.1&nbsp;km)\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-right\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"aeumDefouM?TUAo@?gBC]?G@K?G?S@_@B_@Dm@Ly@VQHC@QHo@`@sDhCOJs@n@eA|@wC`CwDzCcAn@GDkAbAmA~@u@p@o@h@yBvAGDYPYNo@XMFOHg@VKDEDGDIHC@EFGFADEDAFAD?F?R\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6217697,\n" +
                "                        \"lng\" : 77.0878666\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.4 km\",\n" +
                "                        \"value\" : 367\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 62\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6297696,\n" +
                "                        \"lng\" : 77.07820100000001\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Slight \\u003cb\\u003eleft\\u003c/b\\u003e onto \\u003cb\\u003eNajafgarh Rd\\u003c/b\\u003e/\\u003cb\\u003eShivaji Marg\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Metro Pillar Number 588 (on the left)\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-slight-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"e_wmDi_nuMFVDLfAjEzAfFl@|Bb@xA\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6310748,\n" +
                "                        \"lng\" : 77.08165049999999\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"87 m\",\n" +
                "                        \"value\" : 87\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 17\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6301134,\n" +
                "                        \"lng\" : 77.07829\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Slight \\u003cb\\u003eright\\u003c/b\\u003e onto \\u003cb\\u003eU turn for Tilak Ngr, Vikas Puri, Rohini\\u003c/b\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-slight-right\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"awvmDwimuM@ZAHAF?BA@EBGBG?E?AAEACEEIGUIc@\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6297696,\n" +
                "                        \"lng\" : 77.07820100000001\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"79 m\",\n" +
                "                        \"value\" : 79\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 14\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6302554,\n" +
                "                        \"lng\" : 77.0790808\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Continue straight onto \\u003cb\\u003eNajafgarh Rd\\u003c/b\\u003e/\\u003cb\\u003eShivaji Marg\\u003c/b\\u003e\",\n" +
                "                     \"maneuver\" : \"straight\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"eyvmDijmuMC}@Is@Ok@\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6301134,\n" +
                "                        \"lng\" : 77.07829\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.3 km\",\n" +
                "                        \"value\" : 258\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 37\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6313074,\n" +
                "                        \"lng\" : 77.0814305\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Slight \\u003cb\\u003eleft\\u003c/b\\u003e to stay on \\u003cb\\u003eNajafgarh Rd\\u003c/b\\u003e/\\u003cb\\u003eShivaji Marg\\u003c/b\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-slight-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"czvmDgomuMi@}@iAwD}A_F\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6302554,\n" +
                "                        \"lng\" : 77.0790808\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.3 km\",\n" +
                "                        \"value\" : 301\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 42\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6338211,\n" +
                "                        \"lng\" : 77.0806403\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e onto \\u003cb\\u003eOuter Ring Rd\\u003c/b\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"u`wmD}}muMIGMKIEKCKCCBKBGB_@LuBx@mAb@UJIB]L]J]J_@F_@FE@\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6313074,\n" +
                "                        \"lng\" : 77.0814305\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"3.9 km\",\n" +
                "                        \"value\" : 3887\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"8 mins\",\n" +
                "                        \"value\" : 459\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6666485,\n" +
                "                        \"lng\" : 77.0924332\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Keep \\u003cb\\u003eleft\\u003c/b\\u003e to stay on \\u003cb\\u003eOuter Ring Rd\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Municipal Corporation of Delhi (on the left)\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"keep-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"kpwmD_ymuMYH_@J_@He@De@De@@e@@e@Ae@Ce@Ee@Gq@Go@Io@Io@Ko@MOE_@Im@Mo@QKCKEKCKEKCKEKEKCICGCe@OGCs@So@SkA_@AAGCw@WWI_Bi@gA[_AY}Ai@SIQEm@QUEQCQAMAi@Mc@KCAi@Ka@K_@K_@Kk@OQEg@OqA_@c@MwBk@eAWi@M_Bc@KG]Ia@M_IqA[E[GYE[GYI[GYIYKQGQEOGQGQGQIOGQGi@Ui@Wg@Wi@Wg@Wi@Yg@YIG]SQOSOQOQOSQQQEESMAAOOMKmBqACA_Ao@eBy@UMe@WsBuAoAw@MKmCkBECWSUMyCyAWKc@Qq@SeBc@sA[c@GaBYyFk@c@Eg@GSAmBSaDYqEc@UC}@K]EaCW_@GiBUQCoHy@\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6338211,\n" +
                "                        \"lng\" : 77.0806403\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"1.1 km\",\n" +
                "                        \"value\" : 1085\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"2 mins\",\n" +
                "                        \"value\" : 105\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.676307,\n" +
                "                        \"lng\" : 77.09402709999999\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Continue straight onto \\u003cb\\u003eBhera Enclave Underpass\\u003c/b\\u003e/\\u003cb\\u003eOuter Ring Rd\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003eContinue to follow Outer Ring Rd\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"straight\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"q}}mDubpuM]EmAMgD[cCWI?OCQAyCYuHs@mAKsAGcBOo@GsAMIAyHu@}@I{@ISAKAaAKmAM\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6666485,\n" +
                "                        \"lng\" : 77.0924332\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.3 km\",\n" +
                "                        \"value\" : 318\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 79\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6791378,\n" +
                "                        \"lng\" : 77.0943637\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Take the ramp to \\u003cb\\u003eNH9\\u003c/b\\u003e\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"}y_nDulpuM}@Fq@@oAG}Da@c@EcBQEAE?c@G\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.676307,\n" +
                "                        \"lng\" : 77.09402709999999\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"13.8 km\",\n" +
                "                        \"value\" : 13753\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"25 mins\",\n" +
                "                        \"value\" : 1481\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6889251,\n" +
                "                        \"lng\" : 76.9541955\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e onto \\u003cb\\u003eNH9\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Metro Pillar Number 568 (on the right in 7.4&nbsp;km)\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"sk`nDwnpuMO@GBEBGFIPGLEHI^InBUdFCb@YjFMjBKnBKhBGr@CZKzBMlB_@zGYfGALKxBk@fKUxDYvEMfCQlCIdAY`EYtEEdAIdBSdEm@`JKbBIfAAb@Af@?N@h@@JCxKCtG?R?@A`@ClK?dH?XAX?J?~G@^?@?R?fB?bFAp@Cv@G|A?^?|@@z@?DJtE@jA@xA@hB?hA?nAChBChG?tCAfB?t@AnMEdG?hACrG?jKCrFCnH@dA?nBAh@AxAAl@?r@ArGCdD?vCA|C?jAA`B?l@ClKAdB@bBAnGCpBCpAK|CEv@CrACbAAVCd@E|@IhDQzEGjEm@`O_@dKEdAI|AIp@Md@[tDAL?LATAT?LAL?BAv@@v@BRB\\\\@T?VATYbHO|DEbAWzGC\\\\OhFAPK|BGjBKlCY`IGrAG~AKhCC|@UxFG|AGpAKdCWxGM~CGnACj@AXa@nK]nKCh@Ez@Cv@GdAEhAO|DEbAG|AGzAEt@StFEjA_@bIw@|SIjBm@jNOxCAf@]zIe@hLY`GG~BK~COzDCp@AXKdCGrAEjAAZMjCUtHG~AEjAc@~KMtCEb@a@lJAFS`EGfAAPMfBW|D_AfSE`AMzCIrBUjE\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6791378,\n" +
                "                        \"lng\" : 77.0943637\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.7 km\",\n" +
                "                        \"value\" : 738\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 64\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6896098,\n" +
                "                        \"lng\" : 76.9467363\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Continue straight to stay on \\u003cb\\u003eNH9\\u003c/b\\u003e\",\n" +
                "                     \"maneuver\" : \"straight\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"yhbnDwbutMY~JGb@ERINGREb@KpACrAAn@?JBHFHDNANObDe@jKIxAEr@\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6889251,\n" +
                "                        \"lng\" : 76.9541955\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"8.8 km\",\n" +
                "                        \"value\" : 8773\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"9 mins\",\n" +
                "                        \"value\" : 533\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6842735,\n" +
                "                        \"lng\" : 76.8857165\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e to stay on \\u003cb\\u003eNH9\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Power Point (on the left)\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"ambnDctstMv@?lENN@bCDbFP|HV~ELt@D~@JfAP|B^lF|@l@HD?B@@?`@DPB@?p@BhAD~@BzADpCJ`CF`GPjCH|CH~EP\\\\Bl@DVDNBPBd@LXJj@X\\\\RVRLJXVZb@NTJPLVNXJZHVDPDTFZRpAXfBf@tCnApHJf@Jh@ThANl@T`Af@pBj@jB`@xATz@~@bDbAxDb@`Bl@vBz@tCZbAhAnDp@tBf@xAjAnDlBtFdBjFdBdFDLDLHXjCvHbBbFn@lBf@~ALf@@BDPDV@HF\\\\DPF^DXBT@XBZ@^@`@?^?PA^?ZCh@CLE`@C\\\\EXETGVETERENABCJGNGRGPGLWv@e@~@yAtCqAvBqAbC}AvCq@tAq@lAk@|@QZg@t@_@b@m@p@a@\\\\a@`@i@h@STSXWb@[n@IPWd@g@`AWj@_@z@]z@_@dAUn@cC~Hc@tAs@~BY`Aw@nC}@|C{@vCg@xAWh@Yj@_ClGcH|QiDpJmBjFwB`Gq@dBs@bBm@tAcA~By@fBeAtBENy@fB_AxBQ\\\\y@hBaArBo@dAW`@q@x@y@x@_@\\\\o@d@aAl@a@Re@Tu@\\\\o@VaA`@iAd@mAf@_@Pw@ZaHtC\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6896098,\n" +
                "                        \"lng\" : 76.9467363\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.4 km\",\n" +
                "                        \"value\" : 392\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 33\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6873469,\n" +
                "                        \"lng\" : 76.8839966\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e toward \\u003cb\\u003eBahadurgarh - Chhara - Beri Rd\\u003c/b\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"ukanDwvgtMDXOH_E~AwBz@eCdA}Ap@_@Na@N\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6842735,\n" +
                "                        \"lng\" : 76.8857165\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"0.5 km\",\n" +
                "                        \"value\" : 497\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 63\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6870214,\n" +
                "                        \"lng\" : 76.8890787\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Turn \\u003cb\\u003eright\\u003c/b\\u003e at the 1st cross street onto \\u003cb\\u003eBahadurgarh - Chhara - Beri Rd\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003ePass by Batra Bhai (on the left in 450&nbsp;m)\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-right\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"}~anD_lgtMFaBTgJb@}N?U?Y\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6873469,\n" +
                "                        \"lng\" : 76.8839966\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"65 m\",\n" +
                "                        \"value\" : 65\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 17\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.687607,\n" +
                "                        \"lng\" : 76.88908219999999\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e at PNB Bank Atm onto \\u003cb\\u003ePDM Rd\\u003c/b\\u003e\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003eRestricted usage road\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"{|anDwkhtMuB?\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.6870214,\n" +
                "                        \"lng\" : 76.8890787\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"distance\" : {\n" +
                "                        \"text\" : \"13 m\",\n" +
                "                        \"value\" : 13\n" +
                "                     },\n" +
                "                     \"duration\" : {\n" +
                "                        \"text\" : \"1 min\",\n" +
                "                        \"value\" : 7\n" +
                "                     },\n" +
                "                     \"end_location\" : {\n" +
                "                        \"lat\" : 28.6876122,\n" +
                "                        \"lng\" : 76.88894719999999\n" +
                "                     },\n" +
                "                     \"html_instructions\" : \"Turn \\u003cb\\u003eleft\\u003c/b\\u003e at the park\\u003cdiv style=\\\"font-size:0.9em\\\"\\u003eRestricted usage road\\u003c/div\\u003e\",\n" +
                "                     \"maneuver\" : \"turn-left\",\n" +
                "                     \"polyline\" : {\n" +
                "                        \"points\" : \"q`bnDwkhtM?X\"\n" +
                "                     },\n" +
                "                     \"start_location\" : {\n" +
                "                        \"lat\" : 28.687607,\n" +
                "                        \"lng\" : 76.88908219999999\n" +
                "                     },\n" +
                "                     \"travel_mode\" : \"DRIVING\"\n" +
                "                  }\n" +
                "               ],\n" +
                "               \"traffic_speed_entry\" : [],\n" +
                "               \"via_waypoint\" : [\n" +
                "                  {\n" +
                "                     \"location\" : {\n" +
                "                        \"lat\" : 28.6360931,\n" +
                "                        \"lng\" : 77.12833379999999\n" +
                "                     },\n" +
                "                     \"step_index\" : 0,\n" +
                "                     \"step_interpolation\" : 0.1392867694563225\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"location\" : {\n" +
                "                        \"lat\" : 28.6319761,\n" +
                "                        \"lng\" : 77.1111562\n" +
                "                     },\n" +
                "                     \"step_index\" : 1,\n" +
                "                     \"step_interpolation\" : 0.5368189787011165\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"location\" : {\n" +
                "                        \"lat\" : 28.6411864,\n" +
                "                        \"lng\" : 77.10705660000001\n" +
                "                     },\n" +
                "                     \"step_index\" : 2,\n" +
                "                     \"step_interpolation\" : 0.08501632091216402\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"location\" : {\n" +
                "                        \"lat\" : 28.6359271,\n" +
                "                        \"lng\" : 77.0967496\n" +
                "                     },\n" +
                "                     \"step_index\" : 4,\n" +
                "                     \"step_interpolation\" : 0.04701596986734052\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"location\" : {\n" +
                "                        \"lat\" : 28.6086387,\n" +
                "                        \"lng\" : 77.1019646\n" +
                "                     },\n" +
                "                     \"step_index\" : 7,\n" +
                "                     \"step_interpolation\" : 0.06314903602538087\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"location\" : {\n" +
                "                        \"lat\" : 28.613987,\n" +
                "                        \"lng\" : 77.0867667\n" +
                "                     },\n" +
                "                     \"step_index\" : 12,\n" +
                "                     \"step_interpolation\" : 0.03005710447239318\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"location\" : {\n" +
                "                        \"lat\" : 28.6309946,\n" +
                "                        \"lng\" : 77.0814479\n" +
                "                     },\n" +
                "                     \"step_index\" : 15,\n" +
                "                     \"step_interpolation\" : 0.05915935506599346\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"location\" : {\n" +
                "                        \"lat\" : 28.6407644,\n" +
                "                        \"lng\" : 77.08229779999999\n" +
                "                     },\n" +
                "                     \"step_index\" : 20,\n" +
                "                     \"step_interpolation\" : 0.2069148461782058\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"location\" : {\n" +
                "                        \"lat\" : 28.6795021,\n" +
                "                        \"lng\" : 77.0938987\n" +
                "                     },\n" +
                "                     \"step_index\" : 23,\n" +
                "                     \"step_interpolation\" : 0.004738440897940496\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"location\" : {\n" +
                "                        \"lat\" : 28.6714681,\n" +
                "                        \"lng\" : 76.9434095\n" +
                "                     },\n" +
                "                     \"step_index\" : 25,\n" +
                "                     \"step_interpolation\" : 0.2387687203859869\n" +
                "                  },\n" +
                "                  {\n" +
                "                     \"location\" : {\n" +
                "                        \"lat\" : 28.68718,\n" +
                "                        \"lng\" : 76.8890796\n" +
                "                     },\n" +
                "                     \"step_index\" : 28,\n" +
                "                     \"step_interpolation\" : 0.270836098682937\n" +
                "                  }\n" +
                "               ]\n" +
                "            }\n" +
                "         ],\n" +
                "         \"overview_polyline\" : {\n" +
                "            \"points\" : \"mdxmDahwuMp@vAr@h@d@Pf@H|AFrAJ`@JfB~@dCrBrJ`ItFpEnEnDFDKReC`Es@~@GZC`BCdFAlEObXC~IInCSpA[jAe@v@y@hACXCDGDG?iClDs@~@gAXeDx@sA\\\\_An@y@z@cDjD{ArAWLg@FqD?mLCoD?gB?a@NW\\\\AJANX~@tA`Ej@bBvD~MxBdIzB~Gl@pBjDvIpAdDHPJIZGZ@ZJVPLPXAj@OfC}@tC}@~JgDdNmEpC_AlKiDpKuDrC{@hFgB~CaAtAm@bE{B`JwEjIkEpAs@`@a@|FaDnBsAzAiALMX`@bA`BhAfBt@nApChEd@d@~M`GrIzDp@Vm@dB}@dCg@hBOv@AtAZ|ENzBF~AAvAIr@{B|G{CjJOp@k@`Dc@dBiCzH[x@_@lB}AzEw@pCk@zAUdACJFLLb@@VIh@QZULSBUXq@h@OZQb@I?SAOMG_@v@iCwBiAsCmAsEyAsHiB_Cc@iJc@qHWObE?TUAwCCe@@gADmARkA`@yFvDaHzFwDzCcAn@sAhAcCpBiD`CkB`AqAn@[VUZCh@pDxMpAvE?d@IPW@Wg@MaBY_Bi@}@iAwD}A_FIGWQWGw@XcFlByBl@_B^eANkAFkA?kAIwDc@oCi@eD}@{DmAmKgDqDkAgAMiG{AoDcAgIuBi@QaJ_BmB[oDeAeAa@eD}AcCsAuAcAqBeBqBsA_Ao@eBy@{@e@cEmCyDoCkFeCkFsAeCa@}Gq@kIw@cIy@}Gy@cQiBmUwBgF_@uMoA}CYmAM}@FaCEkI{@i@GWD_@j@Oh@_@tIw@jNc@tHiA~SgBr[cA|O}@fQeApP@lBMtl@?fUMfFLtIDxIGxQIrZG|]I~]Mjd@?rJGbEYlJUdHYfLmAf[ObDWvA_@fFCt@?nBFp@@l@[xHq@zP{Ahb@gBpd@{Ara@mAvZgBxc@}Ah_@_AjTS~Ga@lK]fIgA`[w@nPk@bKwAdYS|E_@~Ha@bLOb@Mv@OdDAz@JRB^eA|TxKVvX|@fC\\\\jJ|Ax@JfBLvJZlTl@bI`@`B`@hAl@d@^t@z@Zf@r@dBdElVfAbFjCrJtEvPrE~NbMf_@fIhVZtAVxANdBBrBIrBUnBYpAUr@O^}@vBkDlGoDzGcBbD}@xAgAxAoAnAsBzBuAjC}BdF}EjOcEnNcBpFq@tAcLjZwG|QiDfJaBxDiElJeEhJqBxDiAzAyAvAqBrAmD~AyF`CyIpDDXOHwHzCcFvBaA^\\\\iMb@sO?YuB??X\"\n" +
                "         },\n" +
                "         \"summary\" : \"NH9\",\n" +
                "         \"warnings\" : [],\n" +
                "         \"waypoint_order\" : []\n" +
                "      }\n" +
                "   ],\n" +
                "   \"status\" : \"OK\"\n" +
                "}";
        ParserTask parserTask = new ParserTask();

        // Invokes the thread for parsing the JSON data
        parserTask.execute(fixdata);


    }


    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;


            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();


                // Starts parsing data
                routes = parser.parse(jObject);


            } catch (Exception e) {

                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points;
            PolylineOptions lineOptions = null;

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(18);
                lineOptions.zIndex(4);
                lineOptions.color(Color.BLUE);
                lineOptions.geodesic(true);


            }

            // Drawing polyline in the Google Map for the i-th route
            if(lineOptions != null) {
                map.addPolyline(lineOptions);
            }
            else {

            }
        }
    }
}