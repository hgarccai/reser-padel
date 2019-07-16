package com.reserpadel.services;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.reserpadel.domain.Persona;
import com.reserpadel.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonlService {

	private PersonRepository personrepo;

	/*
	 * Es en el constructor donde spring inyecta las dependencias, con lo que no es
	 * necesario inyectar con @Autowired
	 */
	public PersonServiceImpl(PersonRepository p) {
		this.personrepo = p;
	}

	@Override
	public Persona create(Persona p) {
		// Lambda Consumer (con este parámetro -> hazme esto, o recibe parámetros, hazalgo y no devuelvas nada)
		personrepo.findById(p.getEmail())
				.ifPresent((a) -> new RuntimeException("El usuario " + a.getEmail() + " ya está registrado."));
		return personrepo.save(p);
	}

	@Override
	public List<Persona> findAll() {
		return personrepo.findAll();
	}

	@Override
	public Persona findById(String email) {
		// creamos una función lambda Predicate (con este parámetro -> evalua expresión) para validar que el email de entrada venga informado.
		Predicate<String> isValidEmail = (String e) -> !e.isEmpty() && e != null;

		if (isValidEmail.test(email)) {
			// Lambda Supplier (con ningún paramétro -> haz esto, o no recibe parámetros y haz algo)
			return personrepo.findById(email).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
		} else {
			throw new RuntimeException("El email está vacío o no informado.");
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
