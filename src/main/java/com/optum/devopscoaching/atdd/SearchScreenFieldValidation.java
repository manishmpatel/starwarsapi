package com.optum.devopscoaching.atdd;

import java.util.HashMap;

public class SearchScreenFieldValidation {

	public HashMap generateFieldStates(String screenName, boolean isAdmin) {

		HashMap h = new HashMap();

		if (isAdmin) {
			h.put("EffectiveDate", true);
			h.put("LastUpdated", false);
			} else {
			h.put("EffectiveDate", false);
			h.put("LastUpdated", false);
		}
		return h;

	}
}
