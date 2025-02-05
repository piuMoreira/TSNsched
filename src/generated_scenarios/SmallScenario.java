package generated_scenarios;

import network.Cycle;
import network.Flow;
import network.Network;
import nodes.Device;
import nodes.TSNSwitch;
import schedule_generator.ScheduleGenerator;

public class SmallScenario {
	public void runTestCase(){

		/*
		 * GENERATING DEVICES
		 */
		Device dev0 = new Device(400, 0, 1000, 1250);
		Device dev1 = new Device(400, 0, 1000, 1250);
		Device dev2 = new Device(400, 0, 1000, 1250);
		Device dev3 = new Device(400, 0, 1000, 1250);
		Device dev4 = new Device(400, 0, 1000, 1250);


		/*
		 * GENERATING SWITCHES
		 */
		TSNSwitch switch0 = new TSNSwitch("switch0",100, 8, 125, 1, 400, 3000);



		/*
		 * LINKING SWITCHES TO DEVICES
		 */
		Cycle cycle1 = new Cycle(50);
		switch0.createPort(dev0, cycle1);
		Cycle cycle2 = new Cycle(50);
		switch0.createPort(dev1, cycle2);
		Cycle cycle3 = new Cycle(50);
		switch0.createPort(dev2, cycle3);
		Cycle cycle4 = new Cycle(50);
		switch0.createPort(dev3, cycle4);
		Cycle cycle5 = new Cycle(50);
		switch0.createPort(dev4, cycle5);
		/*
		 * GENERATING FLOWS
		 */

		Flow flow1 = new Flow(Flow.UNICAST);
		flow1.setStartDevice(dev1);
		flow1.addToPath(switch0);
		flow1.setEndDevice(dev0);

		Flow flow2 = new Flow(Flow.UNICAST);
		flow2.setStartDevice(dev2);
		flow2.addToPath(switch0);
		flow2.setEndDevice(dev0);

		Flow flow3 = new Flow(Flow.UNICAST);
		flow3.setStartDevice(dev3);
		flow3.addToPath(switch0);
		flow3.setEndDevice(dev0);


		/*
		 * GENERATING THE NETWORK
		 */
		Network net = new Network(25);
		net.addDevice(dev0);
		net.addDevice(dev1);
		net.addDevice(dev2);
		net.addDevice(dev3);
		net.addDevice(dev4);
		net.addSwitch(switch0);
		
		net.addFlow(flow1);
		net.addFlow(flow2);
		net.addFlow(flow3);


		ScheduleGenerator scheduleGenerator = new ScheduleGenerator(false);
		scheduleGenerator.generateSchedule(net);

	}
}
