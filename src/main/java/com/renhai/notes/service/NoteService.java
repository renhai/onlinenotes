package com.renhai.notes.service;

import static com.google.common.base.Preconditions.*;
import com.renhai.notes.entity.Note;
import com.renhai.notes.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by hai on 2/12/18.
 */
@Service
@Slf4j
public class NoteService {

	@Autowired
	private NoteRepository noteRepository;

	@Transactional
	public Note updateNotes(String id, String notes) {
		checkArgument(StringUtils.isNotBlank(id), "id should not be empty");
		Note entity = noteRepository.findOne(id);
		entity.setModifiedAt(new Date());
		entity.setNotes(StringUtils.trimToEmpty(notes));
		return noteRepository.save(entity);
	}

	@Transactional
	public Note createNote(String id, String notes) {
		checkArgument(StringUtils.isNotBlank(id), "id should not be empty");
		Note entity = Note.builder().id(id).notes(StringUtils.trimToEmpty(notes)).createAt(new Date()).build();
		return noteRepository.save(entity);
	}

	@Transactional
	public String generateId() {
		String id = RandomStringUtils.random(8, true, true);
		while (exist(id)) {
			id = RandomStringUtils.random(8, true, true);
		}
		Note entity = Note.builder().id(id).notes("").createAt(new Date()).build();
		return noteRepository.save(entity).getId();
	}

	private boolean exist(String id) {
		return noteRepository.findOne(id) != null;
	}

	@Transactional
	public Note getNote(String id) {
		return noteRepository.findOne(id);
	}
}
