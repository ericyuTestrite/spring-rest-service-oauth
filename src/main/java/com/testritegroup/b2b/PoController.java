package com.testritegroup.b2b;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testritegroup.b2b.data.PoMst;
import com.testritegroup.b2b.data.PoMstRepository;

import com.testritegroup.b2b.data.User;

@RestController
public class PoController {
	private final PoMstRepository  poMstRepository;
	Logger logger = Logger.getLogger(PoController.class);
	
	@Autowired
	public PoController(PoMstRepository poMstRepository){
		this.poMstRepository = poMstRepository;
	}
	
	@RequestMapping(value="/getAllPo", method=RequestMethod.GET)
	public Iterable<PoMst> getAllPo(@AuthenticationPrincipal User user) {
		logger.info(user.getLogin() + " called /getAllPo!");
		return poMstRepository.findAll();
	}
	
	@RequestMapping(value="/getPo/{poNo}", method=RequestMethod.GET)
	public PoMst getPoByPoNo(Principal user, @PathVariable String poNo) {
		logger.info(user.getName() + " called /getPo "+ poNo);
		return poMstRepository.findByPoNo(poNo);
	}

}
