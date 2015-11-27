package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.JpzlzkdwbDao;
import platform.dao.XzxzgzbDao;
import platform.dao.ZjtxlDao;
import platform.domain.Zjtxl;
import platform.form.ZjtxlForm;
import platform.service.JpzlzkdwbService;
import platform.service.ZjtxlService;
import platform.util.StringHelper;
@Transactional
@SuppressWarnings("unused")
@Service(JpzlzkdwbService.SERVICE_NAME)
public class JpzlzkdwbServiceImpl implements JpzlzkdwbService{
	
	@Resource(name=JpzlzkdwbDao.SERVICE_NAME)
	private JpzlzkdwbDao jpzlzkdwbDao;
	
	
}
