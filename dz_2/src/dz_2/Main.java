package dz_2;

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

        // array of sound-producing devices
        String[] carriers = new String[]{
                "виниловая вертушка",
                "сд"
        };

        // list of sound-producing devices
        List<SoundProducingDevice> spd = new ArrayList<SoundProducingDevice>();
        for(int i=0;i<carriers.length;i++) {
            spd.add(new SoundProducingDevice(carriers[i]));
        }

        // new device
        Device d1 = new Device();

        // adding sound-producing device
        d1.addSoundDevice(spd.get(0));

        // if list of songs are empty
        System.out.println(d1.Play(audio.get(0), spd.get(0)));

        //deleting sound-producing device
        d1.removeSPD(0);

        // adding songs
        d1.addSong(audio.get(0));
        d1.addSong(audio.get(1));

        // if sound-producing device not exist
        System.out.println(d1.Play(audio.get(0), spd.get(0)));

        // adding sound-producing devices
        d1.addSoundDevice(spd.get(0));
        d1.addSoundDevice(spd.get(1));

        // if sound-producing device exist
        System.out.println(d1.Play(audio.get(0), spd.get(0)));
    }
}
