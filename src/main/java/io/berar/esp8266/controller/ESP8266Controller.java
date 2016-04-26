package io.berar.esp8266.controller;

import io.berar.esp8266.service.ESP8266Service;
import io.berar.esp8266.model.TurnSwitch;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aleks_000 on 9/19/2015.
 */

@RestController
@RequestMapping("/")
public class ESP8266Controller {

    @RequestMapping(value = "turn",
                    params = "switch")
    public String turnESP8266(@RequestParam(value = "turn") TurnSwitch turnSwitch) throws Exception {
        boolean turnOn = turnSwitch.equals(TurnSwitch.on) || turnSwitch.equals(TurnSwitch.ON);
        ESP8266Service.switchIt(turnOn);
        return turnOn ? "Switched ON!" : "Switched OFF!";
    }
}