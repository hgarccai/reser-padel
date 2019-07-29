package com.reserpadel.services;

import java.util.List;
//import java.util.Set;
import java.util.function.Predicate;

//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.reserpadel.ConstantString;
import com.reserpadel.domain.Persona;
import com.reserpadel.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	
	final static Logger logger = Logger.getLogger(PersonServiceImpl.class);

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
		/*
		try {
			return performSave(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	/*
	//ÑAPA IMPERATIVA PARA LOS ERRORES DE VALIDACIÓN
	private Persona performSave(Persona ObjectToSave) throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Persona>> constraintViolations = validator.validate(ObjectToSave);

		if (constraintViolations.size() > 0) {
			logger.info("VIOLATION OCCURED");
			for (ConstraintViolation<Persona> contraints : constraintViolations) {
				logger.info(contraints.getRootBeanClass().getSimpleName() + "." + contraints.getPropertyPath() + " "
						+ contraints.getMessage());
				throw new RuntimeException(contraints.getMessage().toString());
			}
		}else {
			return ObjectToSave;
		}
	}*/

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
