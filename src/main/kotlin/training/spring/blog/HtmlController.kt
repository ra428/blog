package training.spring.blog

import org.springframework.ui.Model
// Extension function
import org.springframework.ui.set
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class HtmlController {
    @GetMapping("/")
    fun blog(model: Model): String {
        model["title"] = "Blog"
        return "blog"
    }
}
