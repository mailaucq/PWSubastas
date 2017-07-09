package com.subastas.domain.dao;

import org.springframework.stereotype.Component;

import com.subastas.domain.to.UserItemTag;
import com.subastas.domain.to.UserItemTagKey;
@Component("userItemTagDAO")
public class UserItemTagDAOImpl extends GenericDAOImpl<UserItemTag,UserItemTagKey> implements UserItemTagDAO {
}
