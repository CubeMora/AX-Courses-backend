package com.cubemora.ax_courses.controllers;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cubemora.ax_courses.files.vaporeon;
import com.cubemora.ax_courses.models.testimonialRepository;
import com.cubemora.ax_courses.models.testimonials;

@RestController
@RequestMapping("/api/testimonials")
public class testController {

    String rata = "Hace un tiempo estuve rentando un depa junto con un primo, pero el vato estaba bien pinche loco sexual, seguido llegaba con lavacoches, inditos, morritos vendechicles, indigentes y hasta centroamericanos de las vías del tren. Mi primo, muy buen samaritano, les daba de tragar, los dejaba bañarse, o hasta les rolaba ropa o tenis; todo eso a cambio de cojer o mínimo dejarse mamar la riata.\r\n"
            + //
            "\r\n" + //
            "Admito que al principio no me gustaba mucho la idea, y prefería encerrarme en mi cuarto oyendo música, fumarme un porro o lo que fuera, menos oler a los vagabundos. Pero mi primo iba trayendo weyes más cabrones, yonkis, dementes maltripeados y pues me pedía que lo cuidara por si se ponían agresivos, además que él se apendejaba bastante con los poppers jajaja. Acepté de mala gana, aunque le fui agarrando el gusto y el morbo de ver a cabrones de la calle cojerse sin condón a mi primo.\r\n"
            + //
            "\r\n" + //
            "Una vez, estando yo en la cocina, llegó mi primo y me dio un tufo culerisimo pero cabrooon. Ya pensaba yo que se había traído un cadáver o algo así, cuando me asomo y trajo al pinche vagabundo mas pinche yonki llevado a la verga que se pueden imaginar. Todo mugroso, piojoso, con el pelo hecho rastas como de mugre y mierda, tembloroso con la mirada perdida, y con una chamarra dura de tanta suciedad.\r\n"
            + //
            "\r\n" + //
            "Le dimos una maruchan al wey, y mientras tragaba le dije a mi primo \"numaaa te pasas de cabron\" y nomas me dice \"jaja ya se\". En eso el vato este se mete la mano a la chamarra y agarro mi fusca por si las moscas. Pero nel, el wey nomas saca una pinche ratota muerta toda tiesa, la empapa de tiner y se pone a inhalarla como estopa. Yo dije \"numaaa que pex?!\", y mi primo ya estaba bien caliente, como que le prendió esa chingadera y se aventó así a mamarle la verga, sin siquiera bañarlo.\r\n"
            + //
            "\r\n" + //
            "El mugroso estaba ahí de patas abiertas inhalando su ratota, mientras mi primo le quitó el pantalón todo mugriento, y le sacó la verga. La neta la tenía enorme, quizá hasta estuviera rica sin todas esas capas de esmegma ni las ladillas que adornaban sus rastas púbicas. Mi primo se tragaba toda la riata y yo no sabia si excitarme o vomitar, así que opté por fumarme unos porritos.\r\n"
            + //
            "\r\n" + //
            "Mi primo, todo caliente, se desnudó por completo y le ofreció el culo al malviviente, quien sin pensárselo se puso a mamarselo. El pasivote de mi primo estaba en pleno éxtasis, en un estado de trance al sentir su culo mimado por el hocico del indigente. No tardó mucho el vato en ensartarle su macanota, toda dura y sin condón, haciendo gemir y gritar a mi primo como puta en celo, todo entrado en los poppers.\r\n"
            + //
            "\r\n" + //
            "Estaban en el mete y saca, cuando el wey saca su rata, le da un jalón profundo y toma que se la mete en el ano a mi primazo numaaa. Y dale que se lo sigue cojiendo más duro, empujandole la rata al recto. Una cojida cada vez más brutal, y luego de un rato ya el culo de mi primo escurriendo de mecos. El cabron este luego de sacar su riata ya aguada, se chinga lo último de la maruchan y me empieza a gritar. No se ni que vergas balbuceaba, y ya andaba yo bien mariguas, así que nomas le apunté con la fusca y lo mandé corriendito a chingar a su padre. El vato salió todo escamado que ni tiempo tuvo de ponerse los pantalones jajaja. Y pos yo me quedé ahí dormido.\r\n"
            + //
            "\r\n" + //
            "Al rato me despierto con los gritos y quejidos de mi puto primo. Estaba chille y chille que le dolía el culo y las tripas, ni se acordaba de todo lo que le hizo su amante. Yo de buena onda lo ayude para llevarlo al baño, que acabara de cagar los mecos atorados y numaaa que le sale la pinche rata del culo, pero toda despedazada y llena de gusanos. Mi primo casi se desmaya del susto y me pidió que lo llevara a la clínica pa que le hicieran un lavado jajaja pero bien valiente que se sentía en su calentura jeje es neta.\r\n"
            + //
            "";

    @Autowired
    private testimonialRepository testimonialRepository;

    // CREATE
    @PostMapping("/")
    public ResponseEntity<testimonials> createTestimonial(@RequestBody testimonials testimonial) {
        testimonials newTestimonial = testimonialRepository.save(testimonial);
        return new ResponseEntity<>(newTestimonial, HttpStatus.CREATED);
    }

    // GET
    @GetMapping("/")
    public ResponseEntity<List<testimonials>> getAllTestimonials() {
        List<testimonials> testimonials = testimonialRepository.findAll();
        return new ResponseEntity<>(testimonials, HttpStatus.OK);
    }

    // GET a single testimonial
    @GetMapping("/{id}")
    public ResponseEntity<testimonials> getTestimonialById(@PathVariable Long id) {
        Optional<testimonials> testimonial = testimonialRepository.findById(id);
        if (testimonial.isPresent()) {
            return new ResponseEntity<>(testimonial.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<testimonials> updateTestimonial(@PathVariable Long id,
            @RequestBody testimonials updatedTestimonial) {
        Optional<testimonials> existingTestimonial = testimonialRepository.findById(id);
        if (existingTestimonial.isPresent()) {
            testimonials testimonial = existingTestimonial.get();
            testimonial.setNameTestimonial(updatedTestimonial.getNameTestimonial());
            testimonial.setImgUrl(updatedTestimonial.getImgUrl());
            testimonial.setDescriptionTestimonial(updatedTestimonial.getDescriptionTestimonial());
            testimonial.setProfessionTestimonial(updatedTestimonial.getProfessionTestimonial());
            testimonials updated = testimonialRepository.save(testimonial);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestimonial(@PathVariable Long id) {
        testimonialRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<testimonials> patchTestimonial(@PathVariable Long id,
            @RequestBody Map<String, Object> partialUpdates) {
        Optional<testimonials> existingTestimonial = testimonialRepository.findById(id);

        if (existingTestimonial.isPresent()) {
            testimonials testimonial = existingTestimonial.get();

            if (partialUpdates.containsKey("nameTestimonial")) {
                testimonial.setNameTestimonial((String) partialUpdates.get("nameTestimonial"));
            }
            if (partialUpdates.containsKey("imgUrl")) {
                testimonial.setImgUrl((String) partialUpdates.get("imgUrl"));
            }
            if (partialUpdates.containsKey("descriptionTestimonial")) {
                testimonial.setDescriptionTestimonial((String) partialUpdates.get("descriptionTestimonial"));
            }
            if (partialUpdates.containsKey("professionTestimonial")) {
                testimonial.setProfessionTestimonial((String) partialUpdates.get("professionTestimonial"));
            }
            testimonials updated = testimonialRepository.save(testimonial);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/head", method = RequestMethod.HEAD)
    public ResponseEntity<Void> headTestimonial() {
        vaporeon copy = new vaporeon();

        // ID Exists?

        HttpHeaders headers = new HttpHeaders();
        headers.add("C deisote", "Lo de atras x 2");
        headers.add("Sexo", "Si porfavor");
        headers.add("Vaporeon", copy.getCopypasta());
        // HEADERS goes herea
        return new ResponseEntity<>(headers, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> optionsTestimonial() {
        // ID allowed options
        HttpHeaders headers = new HttpHeaders();
        // HEADERS for the ID
        headers.add("Allow", "GET, POST, PUT, DELETE, HEAD, OPTIONS, PATCH, TRACE");
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.TRACE)
    public ResponseEntity<String> traceTestimonial() {
        // Enumeration<String> headerNames = request.getHeaderNames();
        StringBuilder rata2 = new StringBuilder();
        rata2.append(rata);
        return new ResponseEntity<>(rata2.toString(), HttpStatus.OK);
    }

}
