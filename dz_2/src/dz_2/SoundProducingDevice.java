package dz_2;

public class SoundProducingDevice {

    private String device_name;

    /**
     * Constructor new sound-producing device
     * @param device_name
     */
    public SoundProducingDevice(String device_name) {
        this.device_name = device_name;
    }

    /**
     * @return sound-producing device's name
     */
    public String getDevice_name() {
        return device_name;
    }

}
