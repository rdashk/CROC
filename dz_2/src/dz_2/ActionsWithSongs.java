package dz_2;

import java.util.List;

public interface ActionsWithSongs {

    /**
     * Adding new song
     * @param song - new song
     */
    void addSong(Song song);

    /**
     * Getting all songs
     * @return list of songs
     */
    List<Song> getSongs();

    /**
     *
     * @param song - song's name
     * @param spd - sound-producing device's name
     * @return answer
     */
    String play(Song song, SoundProducingDevice spd);

    /**
     * Adding spd
     * @param spd - sound-producing device's name
     */
    void addSPD(SoundProducingDevice spd);

    /**
     * Deleting spd
     * @param spd - sound-producing device's name
     */
    void removeSPD(SoundProducingDevice spd);
}
