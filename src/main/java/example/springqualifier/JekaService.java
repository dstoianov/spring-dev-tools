package example.springqualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JekaService {

    @Autowired
    @JekaQualifier
    public List<String> list;
}
