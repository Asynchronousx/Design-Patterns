//Our Abstract Factory: it have defined four interface related to a well
//specified concrete factory: to the disk factory, to the tape factory, to the tape device
//and the disk device. We could have defined only the method inside this factory, but the
//Interface-Segregation principle of SOLID would have been broke: we don't want classes
//implements method that doesn't use.
public interface AbstractFactoryHIFI {
    interface AbstractFactoryDisk {
        Media createDisk();
    }

    interface AbstractFactoryTape {
        Media createTape();
    }

    interface AbstractFactoryTapeDevice {
        MediaPlayer createTapeDevice();
    }

    interface AbstractFactoryDiskDevice {
        MediaPlayer createDiskDevice();
    }
}

//Concrete Tape Factory: implements the specified interface from the abstract factory.
class ConcreteTapeFactory implements AbstractFactoryHIFI.AbstractFactoryTape {

    //Method override to define it's own logic
    @Override
    public Media createTape() {
        return new Tape();
    }

    //Concrete product A: Tape implement itw own method to write and read content.
    private class Tape implements Media {
        String content;

        @Override
        public void writeContent(String content) {
            this.content = content;
        }

        @Override
        public String readContent() {
            return this.content;
        }
    }

}

//Concrete Disk Factory: implements the specified interface from the abstract factory.
class ConcreteDiskFactory implements AbstractFactoryHIFI.AbstractFactoryDisk {

    //Method override to define it's own logic
    @Override
    public Media createDisk() {
        return new Disk();
    }

    //Concrete product A: Disk implements its own method to write and read content.
    private class Disk implements Media {
        String content;

        @Override
        public void writeContent(String content) {
            this.content = content;
        }

        @Override
        public String readContent() {
            return this.content;
        }
    }

}

//Concrete Tape Device Factory: implements the specified interface from the abstract factory.
class ConcreteTapeDeviceFactory implements AbstractFactoryHIFI.AbstractFactoryTapeDevice {

    //Method override to define it's own logic
    @Override
    public MediaPlayer createTapeDevice() {
        return new TapeRecorder();
    }

    //Concrete product B: A tape recorder can play and record content on the tape.
    private class TapeRecorder implements MediaPlayer {
        @Override
        public void record(Media type, String content) {
            type.writeContent(content);
        }

        @Override
        public void play(Media type) {
            System.out.println(type.readContent());
        }
    }

}

//Concrete Disk Device Factory: implements the specified interface from the abstract factory.
class ConcreteDiskDeviceFactory implements AbstractFactoryHIFI.AbstractFactoryDiskDevice {

    //Method override to define it's own logic
    @Override
    public MediaPlayer createDiskDevice() {
        return new DiskRecorder();
    }

    //Concrete product B: A disk recorder can play and record content on the disk.
    private class DiskRecorder implements MediaPlayer {
        @Override
        public void record(Media type, String content) {
            type.writeContent(content);
        }

        @Override
        public void play(Media type) {
            System.out.println(type.readContent());
        }
    }

}

//Abstract product A: media represent the kind of object that can be played by a tape or disk device.
interface Media {
    void writeContent(String content);
    String readContent();
}

//Abstract product B: a device represent the object that can play a media.
interface MediaPlayer {
    void record(Media type, String content);
    void play(Media type);
}





