public class Main {
    public static void main(String[] args) {
        //Creating disks,tapes and their device factory
        AbstractFactoryHIFI.AbstractFactoryTape tapeFactory = new ConcreteTapeFactory();
        AbstractFactoryHIFI.AbstractFactoryDisk diskFactory = new ConcreteDiskFactory();
        AbstractFactoryHIFI.AbstractFactoryTapeDevice tapeDeviceFactory = new ConcreteTapeDeviceFactory();
        AbstractFactoryHIFI.AbstractFactoryDiskDevice diskDeviceFactory = new ConcreteDiskDeviceFactory();

        //Creating the object
        Media tape = tapeFactory.createTape();
        Media disk = diskFactory.createDisk();
        MediaPlayer tapePlayer = tapeDeviceFactory.createTapeDevice();
        MediaPlayer diskPlayer = diskDeviceFactory.createDiskDevice();

        //Recording and playing
        tapePlayer.record(tape, "FILM: KING KONG - 1950");
        diskPlayer.record(disk, "FILM: AVENGER (BLU RAY) - 2008");
        tapePlayer.play(tape);
        diskPlayer.play(disk);


    }
}
