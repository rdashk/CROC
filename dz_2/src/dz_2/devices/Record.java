package dz_2.devices;

import dz_2.ActionsWithSongs;
import dz_2.Device;
import dz_2.Song;
import dz_2.SoundProducingDevice;

import java.util.ArrayList;
import java.util.List;

public class Record extends Device implements ActionsWithSongs {

    // list of songs
    private List<Song> songs;

    // list of sound-producing devices
    private List<SoundProducingDevice> spd;

    /**
     * Constructor record
     */
    public Record() {
        super("record");
        this.songs = new ArrayList<Song>();
        this.spd = new ArrayList<SoundProducingDevice>();
    }

    @Override
    public void addSong(Song song) {
        this.songs.add(song);
    }

    @Override
    public List<Song> getSongs() {
        return this.songs;
    }

    @Override
    public String play(Song song, SoundProducingDevice d) {
        return super.Play(this.songs, song, this.spd, d);
    }

    @Override
    public void addSPD(SoundProducingDevice spd) {
        this.spd.add(spd);
    }

    @Override
    public void removeSPD(SoundProducingDevice spd) {
        this.spd.remove(spd);
    }
}
