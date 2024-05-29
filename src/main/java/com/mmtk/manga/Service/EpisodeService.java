package com.mmtk.manga.Service;

import com.mmtk.manga.Model.Episode;
import com.mmtk.manga.Repository.EpisodeRepository;
import com.mmtk.manga.Repository.WebtoonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class EpisodeService {

    private final EpisodeRepository episodeRepository;
    private final WebtoonRepository webtoonRepository;

    public EpisodeService(EpisodeRepository episodeRepository, WebtoonRepository webtoonRepository) {
        this.episodeRepository = episodeRepository;
        this.webtoonRepository = webtoonRepository;
    }

    public Episode addEpisode(Episode episode){
        return episodeRepository.save(episode);
    }

    public Episode editEpisode(@PathVariable Long episodeId,Episode episode){

        Episode existingEpisode = episodeRepository.findById(episodeId).orElseThrow(() -> new RuntimeException("Episode not found with id " + episodeId));
        existingEpisode.setEpisodeName(episode.getEpisodeName());
        existingEpisode.setUploadDate(episode.getUploadDate());

        return episodeRepository.save(existingEpisode);
    }

    public void deleteEpisode(@PathVariable Long episodeid){
        episodeRepository.deleteById(episodeid);
    }
}
