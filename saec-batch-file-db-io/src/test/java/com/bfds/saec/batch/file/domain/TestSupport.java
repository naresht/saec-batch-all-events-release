package com.bfds.saec.batch.file.domain;


import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Service
public class TestSupport {

    @PersistenceContext(unitName = "batchFilesEntityManagerFactory")
    private EntityManager entityManager;
    /**
     * Deletes all FileRecord and FileItemError records from DB.
     */
    public static void cleanDb() {
//        for(FileRecord e : FileRecord.findAllFileRecords()) {
//            e.remove();
//        }
        for(FileItemError e : FileItemError.findAllFileItemErrors()) {
            e.remove();
        }
        for(VendorConfig e : VendorConfig.findAllVendorConfigs()) {
            e.remove();
        }
    }

    public List<?> findAll(Class<?> class_) {
        return entityManager.createQuery("from "+class_.getName(), class_).getResultList();
    }

    public static Class<?> getParametrisedTypeClass(Object obj, int index) {
        return  ((Class) ((ParameterizedType) obj.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[index]);
    }

    public static Method getFindAllMethod(Class recordClass) {
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(recordClass);
        for(final Method m : methods) {
            if(m.getName().startsWith("findAll")) {
                return m;
            }
        }
        return null;
    }

}
