package dz_2;

import dz_2.devices.Record;
import dz_2.sound_pr_dev.CD;
import dz_2.sound_pr_dev.VinylTurntable;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // array of authors
        String[] authors = new String[]{
                "John McCrea",
                "Umberto Tozzi"
        };

        // array of songs
        String[] songs = new String[]{
                "I Wanna Be Your Dog",
                "Ti amo"
        };

        // list of author with his song
        List<Song> audio = new ArrayList<Song>();
        for(int i=0;i<authors.length;i++) {
            audio.add(new Song(authors[i], songs[i]));
        }

        // new device
        Record d1 = new Record();

        //adding sound-producing device
        d1.addSPD(new VinylTurntable());

        // if list of songs are empty
        System.out.println(d1.play(audio.get(0), new VinylTurntable()));

        //deleting sound-producing device
        d1.removeSPD(new VinylTurntable());

        // adding songs
        d1.addSong(audio.get(0));
        d1.addSong(audio.get(1));

        // if sound-producing device not exist
        System.out.println(d1.play(audio.get(0), new CD()));

        // adding sound-producing devices
        d1.addSPD(new VinylTurntable());
        d1.addSPD(new CD());

        // if sound-producing device exist
        System.out.println(d1.play(audio.get(0), new CD()));
    }
}
