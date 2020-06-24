package vlad.fedash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MapAdapter extends XmlAdapter<MapAdapter.AdaptedMap, Map<KeyById, Reader>> {
	
	public static class AdaptedMap {

        public List<Entry> entry = new ArrayList<Entry>();

    }

    public static class Entry {

        public KeyById key;

        public Reader value;

    }

	@Override
	public AdaptedMap marshal(Map<KeyById, Reader> map) throws Exception {
		AdaptedMap adaptedMap = new AdaptedMap();
		 for(Map.Entry<KeyById, Reader> mapEntry : map.entrySet()) {
	            Entry entry = new Entry();
	            entry.key = mapEntry.getKey();
	            entry.value = mapEntry.getValue();
	            adaptedMap.entry.add(entry);
	        }
	        return adaptedMap;
	}

	@Override
	public Map<KeyById, Reader> unmarshal(AdaptedMap adaptedMap) throws Exception {
		Map<KeyById, Reader> map = new HashMap<KeyById, Reader>();
		   for(Entry entry : adaptedMap.entry) {
	            map.put(entry.key, entry.value);
	        }
	        return map;
	}
}
