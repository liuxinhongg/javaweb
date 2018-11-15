
package com.bdxh.kmsale.controller;

import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ModelMap;
import com.bdxh.kmsale.utils.EnvironmentAttributes;
import com.bdxh.kmsale.utils.Persistable;

public abstract class AbstractBackendController<M extends Persistable, ID extends Serializable> extends AbstractController<M, ID> {


	protected EnvironmentAttributes environment;
	protected String uploadPath = StringUtils.EMPTY;
	protected String uploadContextPath = StringUtils.EMPTY;
	protected String mediaServerDomain = StringUtils.EMPTY;

	protected void initProps() {
		if (null == environment) {
			environment = EnvironmentAttributes.getInstance();
			uploadPath = environment.getProperty("upload.path", "");
			uploadContextPath = environment.getProperty("upload.contextPath", "/upload/");
			mediaServerDomain = environment.getProperty("media.server.domain", "http://localhost/media");
		}
	}

	protected void initProps(ModelMap model) {
		initProps();
		model.put("mediaServerDomain", mediaServerDomain);
	}

	protected String getFilePhysicalPath(final String path) {
		initProps();
		String physicalPath = "";
		if (path.length() > 0 && path.startsWith(uploadContextPath)) {
			physicalPath = path.substring(path.indexOf(uploadContextPath) + uploadContextPath.length(), path.length());
			physicalPath = uploadPath + physicalPath;
		}
		return physicalPath;
	}
}