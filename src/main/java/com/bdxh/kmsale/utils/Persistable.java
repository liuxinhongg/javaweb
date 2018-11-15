package com.bdxh.kmsale.utils;

import java.io.Serializable;

public interface Persistable extends Serializable {

	Long getId();

	boolean isNew();

	void beforPersist();

	void afterPersist();

	void beforUpdate();

	void afterUpdate();

	void beforRemove();

	void afterRemove();
}