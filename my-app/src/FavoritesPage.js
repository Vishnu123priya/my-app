import React from 'react';
import { Container, Typography, ImageList, ImageListItem, ImageListItemBar } from '@mui/material';

const FavoritesPage = ({ favorites, bookmarks }) => {
  return (
    <Container>
      <Typography variant="h4" component="h2" gutterBottom>
        Favorites
      </Typography>
      <ImageList sx={{ width: 500, height: 450 }}>
        {favorites.map((img) => (
          <ImageListItem key={img}>
            <img
              srcSet={`${img}?w=248&fit=crop&auto=format&dpr=2 2x`}
              src={`${img}?w=248&fit=crop&auto=format`}
              alt="Favorite"
              loading="lazy"
            />
            <ImageListItemBar title="Favorite" />
          </ImageListItem>
        ))}
      </ImageList>

      <Typography variant="h4" component="h2" gutterBottom>
        Bookmarks
      </Typography>
      <ImageList sx={{ width: 500, height: 450 }}>
        {bookmarks.map((img) => (
          <ImageListItem key={img}>
            <img
              srcSet={`${img}?w=248&fit=crop&auto=format&dpr=2 2x`}
              src={`${img}?w=248&fit=crop&auto=format`}
              alt="Bookmark"
              loading="lazy"
            />
            <ImageListItemBar title="Bookmark" />
          </ImageListItem>
        ))}
      </ImageList>
    </Container>
  );
};

export default FavoritesPage;
