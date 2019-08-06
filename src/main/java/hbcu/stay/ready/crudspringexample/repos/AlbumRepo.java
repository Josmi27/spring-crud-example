package hbcu.stay.ready.crudspringexample.repos;

import hbcu.stay.ready.crudspringexample.models.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepo extends CrudRepository<Album, Long> {
}
