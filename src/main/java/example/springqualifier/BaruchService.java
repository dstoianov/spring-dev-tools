package example.springqualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaruchService {

    @Autowired
    @BaruchQualifier
    public List<String> list;
}
