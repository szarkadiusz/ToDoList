package com.Core;
import java.util.Optional;

class LangRepository {

    Optional<Lang> findById(Integer id) {
//        return languages.stream().filter(l -> l.getId().equals(id)).findFirst();
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        Optional<Lang> result = Optional.ofNullable(session.get(Lang.class, id));
        transaction.commit();
        session.close();
        return result;
    }
}