package fr.wallet.controller;

import fr.wallet.domain.Wrapper;
import fr.wallet.repository.WrapperJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class WrapperController {

    @Autowired
    private WrapperJPARepository wrapperJPARepository;

    @GetMapping(path = "/wrappers")
    public List<Wrapper> findAll() {
        return wrapperJPARepository.findAll();
    }
}
