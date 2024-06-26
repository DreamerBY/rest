package com.hstn.rest.my_controller;


import com.hstn.rest.entity.Pupil;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api") //localhost..../api
public class PupilRestController {



  private List<Pupil> pupils;

  @PostConstruct
  public void createListOfPupils() {
    java.time.LocalDateTime currentDateTime = java.time.LocalDateTime.now();
    System.out.println("createListOfPupils "+currentDateTime);

    pupils = new ArrayList<>();
    Pupil pupil1 = new Pupil("Serg", "Bul");
    Pupil pupil2 = new Pupil("Oleg", "Petrov 6566");
    Pupil pupil3 = new Pupil("Ivan", "Ivanov");
    pupils.add(pupil1);
    pupils.add(pupil2);
    pupils.add(pupil3);
  }

  //выводит всекх учеников
  @GetMapping("/pupils")
  public List<Pupil> getPupil() {
    return pupils;
  }

  @GetMapping("/pupils/{pupilIndex}")
  public Pupil getPupilByIndexOfArrayList(@PathVariable /*(name = "pupilIndex")*/ int pupilIndex) {
    if (pupilIndex < 0 || pupilIndex >= pupils.size()) {
      throw new PupilNotFoundException("Pupil id " + pupilIndex + " not found");
    }
    return pupils.get(pupilIndex);
  }




}
