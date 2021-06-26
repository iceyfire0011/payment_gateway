package config;

import model.User;
import view.viewModel.UserViewModel;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class GenericMapper {

    public Object getConvertedResult(Object s, Object d) throws NoSuchFieldException, IllegalAccessException {
        Field sourceFields[] = s.getClass().getDeclaredFields();
        Field destinationFields[] = d.getClass().getDeclaredFields();
        Map<String, String> sourceMap = new HashMap<>();
        Map<String, String> destinationMap = new HashMap<>();
        for (Field field : sourceFields) {
            Field fs = s.getClass().getDeclaredField(field.getName());
            fs.setAccessible(true);
            sourceMap.put(field.getName(), (String) fs.get(s));
        }


        for (Field field : destinationFields) {
            Field fd = d.getClass().getDeclaredField(field.getName());
            fd.setAccessible(true);
            String fdName = (String)field.getName();
            if (sourceMap.containsKey(field.getName())){
                System.out.println(fd);
                fd.set(fd, sourceMap.get(field.getName()));
            }
        }
        for (Map.Entry m : sourceMap.entrySet()) {
            System.out.println(m.getKey() + " > " + m.getValue());

        }
//        for (Field source : sourceFields) {
//            for (Field destination : destinationFields) {
//                if (source.getName().equals(destination.getName()) && source.getType() == destination.getType()) {
//                    Field fs = s.getClass().getDeclaredField(source.getName());
//                    Field fd = d.getClass().getDeclaredField(destination.getName());
//                    fs.setAccessible(true);
//                    fd.setAccessible(true);
//                    fd.set(fd, fs.get(s));
//                    System.out.println(fd.get(d));
//
//                }
//            }
//        }
        return d;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User u = new User();
        u.setId("1");
        u.setUsername("admin");
        u.setPassword("pass");
        u.setFullName("me");
        var data = new GenericMapper().getConvertedResult(u, new UserViewModel());
        System.out.println(data);
    }
}
