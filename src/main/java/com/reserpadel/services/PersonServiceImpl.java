package com.reserpadel.services;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.reserpadel.ConstantString;
import com.reserpadel.domain.Persona;
import com.reserpadel.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personrepo;
	private ConstantString constants;

	/*
	 * Es en el constructor donde spring inyecta las dependencias, con lo que no es
	 * necesario inyectar con @Autowired
	 */
	public PersonServiceImpl(PersonRepository p, ConstantString m) {
		this.personrepo = p;
		this.constants = m;
	}

	@Override
	public Persona create(Persona p) {
		// Lambda Consumer (con este parámetro -> hazme esto, o recibe parámetros,
		// haz algo y no devuelvas nada)
		personrepo.findById(p.getEmail()).ifPresent(a -> {
			throw new RuntimeException(a.getEmail() + constants.getUserexist());
		});
		return personrepo.save(p);
	}

	@Override
	public List<Persona> findAll() {
		return personrepo.findAll();
	}

	@Override
	public Persona findById(String email) {
		// creamos una función lambda Predicate (con este parámetro -> evalua expresión)
		// para validar que el email de entrada venga informado.
		Predicate<String> isValidEmail = (String e) -> !e.isEmpty() && e != null;

		if (isValidEmail.test(email)) {
			// Lambda Supplier (con ningún paramétro -> haz esto, o no recibe parámetros y
			// haz algo)
			return personrepo.findById(email).orElseThrow(() -> new RuntimeException(constants.getPersonnotfound()));
		} else {
			throw new RuntimeException(constants.getEmailerror());
		}
	}

	@Override
	public Persona update(String email, Persona p) {

		return null;
	}

	@Override
	public Persona delete(String email) {

		Persona p = findById(email);
		personrepo.deleteById(email);
		return p;
	}
}
