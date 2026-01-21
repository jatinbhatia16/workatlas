package in.workatlas.service;

import in.workatlas.domain.Category;
import in.workatlas.domain.City;
import in.workatlas.repo.CategoryRepository;
import in.workatlas.repo.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LookupService {

  private final CityRepository cityRepository;
  private final CategoryRepository categoryRepository;

  public List<City> cities() { return cityRepository.findAll(); }

  public List<Category> categories() { return categoryRepository.findAll(); }
}
