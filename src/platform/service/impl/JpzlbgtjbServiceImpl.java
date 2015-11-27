package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.JpzlbgtjbDao;
import platform.dao.JpzlzkdwbDao;
import platform.dao.XzxzgzbDao;
import platform.dao.ZjtxlDao;
import platform.domain.Zjtxl;
import platform.form.ZjtxlForm;
import platform.service.JpzlbgtjbService;
import platform.service.JpzlzkdwbService;
import platform.service.ZjtxlService;
import platform.util.StringHelper;
@Transactional
@SuppressWarnings("unused")
@Service(JpzlbgtjbService.SERVICE_NAME)
public class JpzlbgtjbServiceImpl implements JpzlbgtjbService{
	
	@Resource(name=JpzlbgtjbDao.SERVICE_NAME)
	private JpzlbgtjbDao jpzlbgtjbDao;
	
	
}
