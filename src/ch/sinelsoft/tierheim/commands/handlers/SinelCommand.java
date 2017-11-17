package ch.sinelsoft.tierheim.commands.handlers;

import ch.sinelsoft.tierheim.commands.ICommand;

public class SinelCommand implements ICommand {

	@Override
	public boolean handle(String[] params) {
		System.out.println("Wuuuuuuhuuuuuuu");
		return true;
	}

}
