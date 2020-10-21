package idv.heimlich.dbTransfer.common.evn;

public class EVNConfigFactoryImpl extends EVNConfigFactory {
	
	private IEVNConfig config;

	@Override
	public IEVNConfig getConfig() {
		if (this.config == null) {
			this.config = new EVNConfig();
		}		
		return this.config;
	}

}
