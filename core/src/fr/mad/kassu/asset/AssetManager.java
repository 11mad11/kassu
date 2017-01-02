package fr.mad.kassu.asset;

import com.badlogic.gdx.utils.ObjectMap;

public class AssetManager extends com.badlogic.gdx.assets.AssetManager {
	private ObjectMap<Class<?>,Object> defaults;
	
	public <T> void setDefault(Class<T> type,T o){
		defaults.put(type, o);
	}
	
	@Override
	public synchronized <T> T get(String fileName, Class<T> type) {
		T rep = super.get(fileName);
		return rep==null?(T)defaults.get(type):rep;
	}
}
