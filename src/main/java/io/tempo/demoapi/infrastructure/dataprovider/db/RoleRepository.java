package io.tempo.demoapi.infrastructure.dataprovider.db;

import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.Set;

@Repository
public class RoleRepository {

    private static Set<String> list = new LinkedHashSet<>();

    public Set<String> roles() {
        list.add("Developer");
        list.add("Product Owner");
        list.add("Tester");
        return list;
    }

}
