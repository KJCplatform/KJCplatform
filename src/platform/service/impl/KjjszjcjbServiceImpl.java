package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.KjjszjcjbDao;
import platform.service.KjjszjcjbService;
import platform.util.StringHelper;
@Transactional
@Service(KjjszjcjbService.SERVICE_NAME)
public class KjjszjcjbServiceImpl implements KjjszjcjbService{
	
	@Resource(name=KjjszjcjbDao.SERVICE_NAME)
	private KjjszjcjbDao kjjszjcjbDao;


	
}
