package com.redguarden.kafkaserverapp;

import com.redguarden.kafkaserverapp.StarshipDto;

public interface StarshipService {

    StarshipDto save(StarshipDto dto);

    void send(StarshipDto dto);

    void consume(StarshipDto dto);
}