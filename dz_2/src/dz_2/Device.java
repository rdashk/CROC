package dz_2;

import dz_2.Song;
import dz_2.SoundProducingDevice;

import java.util.*;

public class Device {

    String device_name;

    public Device(String device_name) {
        this.device_name = device_name;
    }

    /**
     * @param s - song's name
     * @param d - spd's name
     * @return spd + song's author + song's name
     */
    protected String Play(List<Song> songs, Song s, List<SoundProducingDevice> spd, SoundProducingDevice d) {

        // list of sound-producing devices is empty
        if (spd.isEmpty()) {
            return "List of sound-producing devices is empty!";
        }

        // list of songs is empty
        if (songs.isEmpty()) {
            return "List of songs is empty!";
        }

        // song not exist
        if (!songs.contains(s)) {
            return "Choose other song!";
        }

        // sound-producing device not exist
        for (SoundProducingDevice x: spd) {
            if (Objects.equals(x.getClass(), d.getClass())) {
                return d.getDevice_name() + ":\n  " + s.getAuthor() + " '" + s.getName() + "'";
            }
        }

        return "Choose other sound-producing device!";
    }
}
