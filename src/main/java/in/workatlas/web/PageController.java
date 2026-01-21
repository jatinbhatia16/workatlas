package in.workatlas.web;

import in.workatlas.dto.CreateProfessionalRequest;
import in.workatlas.service.LookupService;
import in.workatlas.service.ProfessionalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PageController {

  private final LookupService lookupService;
  private final ProfessionalService professionalService;

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("cities", lookupService.cities());
    model.addAttribute("categories", lookupService.categories());
    return "home";
  }

  @GetMapping("/find")
  public String find(@RequestParam(required = false) String city,
                     @RequestParam(required = false) String category,
                     @RequestParam(defaultValue = "0") int page,
                     Model model) {
    model.addAttribute("cities", lookupService.cities());
    model.addAttribute("categories", lookupService.categories());
    model.addAttribute("selectedCity", city == null ? "" : city);
    model.addAttribute("selectedCategory", category == null ? "" : category);

    var results = professionalService.searchApproved(city, category, page, 20);
    model.addAttribute("results", results);
    return "find";
  }

  @GetMapping("/professionals")
  public String professionals(Model model) {
    model.addAttribute("cities", lookupService.cities());
    model.addAttribute("categories", lookupService.categories());
    return "professionals";
  }

  @GetMapping("/register")
  public String register(Model model) {
    model.addAttribute("cities", lookupService.cities());
    model.addAttribute("categories", lookupService.categories());
    model.addAttribute("form", new CreateProfessionalRequest());
    return "register";
  }

  @PostMapping("/register")
  public String registerSubmit(@Valid @ModelAttribute("form") CreateProfessionalRequest form,
                               BindingResult binding,
                               Model model) {
    model.addAttribute("cities", lookupService.cities());
    model.addAttribute("categories", lookupService.categories());
    if (binding.hasErrors()) return "register";
    var created = professionalService.create(form);
    model.addAttribute("createdId", created.getId());
    return "register_success";
  }

  @GetMapping("/pricing")
  public String pricing() { return "pricing"; }

  @GetMapping("/legal/privacy")
  public String privacy() { return "privacy"; }

  @GetMapping("/legal/terms")
  public String terms() { return "terms"; }

  @GetMapping("/legal/disclaimer")
  public String disclaimer() { return "disclaimer"; }
}
