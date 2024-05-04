from django.db import models
from django.utils import timezone
from apps.user.models import CustomUser


class Note(models.Model):
    user = models.ForeignKey(CustomUser, on_delete=models.CASCADE)
    title = models.CharField(max_length=100)
    body = models.TextField(max_length=500)
    create_time = models.DateTimeField(default=timezone.now)

    def __str__(self):
        return self.title
