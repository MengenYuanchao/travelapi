package com.travel.travelapi.api.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travelTrip")
@Api(value = "旅程信息",description = "旅程信息")
public class TravelTripController {
}
