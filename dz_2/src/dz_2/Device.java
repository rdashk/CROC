package dz_2;

import java.util.*;

public class Device {

    // list of songs
    private List<Song> songs;

    // list of sound-producing devices
    private List<SoundProducingDevice> spd;

    /**
     * Constructor new device
     */
    public Device() {
        this.songs = new ArrayList<Song>();
        this.spd = new ArrayList<SoundProducingDevice>();
    }

    /**
     * @param song - new song's name
     */
    public void addSong(Song song) {
        this.songs.add(song);
    }

    /**
     * @param d - new spd 's name
     */
    public void addSoundDevice(SoundProducingDevice d) {
        this.spd.add(d);
    }

    /**
     * @param id - spd's index for removing
     */
    public void removeSPD(int id){

        // if id not exist in spd list
        if (id < 0 || id >= spd.size())
            throw new IndexOutOfBoundsException();

        spd.remove(id);
    }

    /**
     * @param song - song's name
     * @param d - spd's name
     * @return spd + song's author + song's name
     */
    public String Play(Song song, SoundProducingDevice d) {

        // list of sound-producing devices is empty
        if (spd.isEmpty()) {
            return "List of sound-producing devices is empty!";
        }

        // list of songs is empty
        if (songs.isEmpty()) {
            return "List of songs is empty!";
        }

        // sound-producing device not exist
        if (!this.spd.contains(d)) {
            return "Choose other sound-producing device!";
        }

        // song not exist
        if (!this.songs.contains(song)) {
            return "Choose other song!";
        }

        return d.getDevice_name() + ":\n  " + song.getAuthor() + " '" + song.getName() + "'";
    }
}
