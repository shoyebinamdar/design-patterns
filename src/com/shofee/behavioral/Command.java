package com.shofee.behavioral;

interface CommandInterface {
    void execute();
}

class Light {
    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}

class LightOnCommand implements CommandInterface {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}

class LightOffCommand implements CommandInterface {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}

class Stereo
{
    public void on()
    {
        System.out.println("Stereo is on");
    }
    public void off()
    {
        System.out.println("Stereo is off");
    }
    public void setCD()
    {
        System.out.println("Stereo is set " +
                "for CD input");
    }
    public void setDVD()
    {
        System.out.println("Stereo is set"+
                " for DVD input");
    }
    public void setRadio()
    {
        System.out.println("Stereo is set" +
                " for Radio");
    }
    public void setVolume(int volume)
    {
        // code to set the volume
        System.out.println("Stereo volume set"
                + " to " + volume);
    }
}
class StereoOffCommand implements CommandInterface
{
    Stereo stereo;
    public StereoOffCommand(Stereo stereo)
    {
        this.stereo = stereo;
    }
    public void execute()
    {
        stereo.off();
    }
}

class StereoOnWithCDCommand implements CommandInterface
{
    Stereo stereo;
    public StereoOnWithCDCommand(Stereo stereo)
    {
        this.stereo = stereo;
    }
    public void execute()
    {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}

class RemoteControl {
    CommandInterface slot;

    public void setSlot(CommandInterface slot) {
        this.slot = slot;
    }

    public void buttonPressed() {
        slot.execute();
    }
}

public class Command {
    public static void main(String args[]) {
        CommandInterface lightOnCommand = new LightOnCommand(new Light());
        CommandInterface lightOffCommand = new LightOffCommand(new Light());
        CommandInterface stereoOnWithCDCommand = new StereoOnWithCDCommand(new Stereo());
        CommandInterface stereoOffCommand = new StereoOffCommand(new Stereo());

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setSlot(lightOnCommand);
        remoteControl.buttonPressed();

        remoteControl.setSlot(lightOffCommand);
        remoteControl.buttonPressed();

        remoteControl.setSlot(stereoOnWithCDCommand);
        remoteControl.buttonPressed();

        remoteControl.setSlot(stereoOffCommand);
        remoteControl.buttonPressed();
    }
}
