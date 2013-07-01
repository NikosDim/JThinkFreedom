package org.scify.jthinkfreedom;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.scify.jthinkfreedom.reactors.ApplicationLaunchReactor;
import org.scify.jthinkfreedom.reactors.RightClickReactor;
import org.scify.jthinkfreedom.sensors.MouseMotionSensor;
import org.scify.jthinkfreedom.stimuli.MouseClickStimulus;

/**
 *
 * @author nikos
 */
public class TestMain {

    public static void main(String[] args) {
    	MouseMotionSensor mouseSensor = new MouseMotionSensor();
		MouseClickStimulus clickStimulus = new MouseClickStimulus(1);
		ApplicationLaunchReactor appLaunch = new ApplicationLaunchReactor("/usr/bin/gedit");
		
		mouseSensor.addStimulus(clickStimulus);
		clickStimulus.addSensor(mouseSensor);
		clickStimulus.addReactor(appLaunch);
    }
}
